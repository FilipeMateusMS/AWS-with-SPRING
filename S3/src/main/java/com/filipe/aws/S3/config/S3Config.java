package com.filipe.aws.S3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Value( "${cloud.aws.region.static}")
    private String region;

    @Bean( "s3Client" )
    @Profile( "local" )
    // As propriedades de acess-key e secret-key são utilizadas somente quando a aplicação está fora da AWS
    public S3Client s3Client(
            @Value( "${cloud.aws.credentials.secret-key}") String secretKey,
            @Value( "${cloud.aws.credentials.access-key}") String acessKey ){
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create( acessKey, secretKey );
        return S3Client.builder()
                .region( Region.of( region ) )
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials ) )
                .build();
    }

    @Bean( "s3Client" )
    @Profile( "aws" ) // Para quando a aplicação estiver a rodar na AWS
    public S3Client s3ClientAws(){
        return S3Client.builder()
                .region( Region.of( region ) )
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
