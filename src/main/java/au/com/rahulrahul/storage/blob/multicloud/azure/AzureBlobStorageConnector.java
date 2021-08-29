package au.com.rahulrahul.storage.blob.multicloud.azure;


import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

/**
 * Hello world!
 *
 */
public class AzureBlobStorageConnector 
{
    String accessKey = null;
    String containerName = null;
    public void setStorageAccountKey(String key){
        this.accessKey = key;
    }

    public void setContainerName(String containerName){
        this.containerName = containerName;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AzureBlobStorageConnector conn = new AzureBlobStorageConnector();
        conn.connect();
        conn.put(null);
    }

    public void connect(){
        this.setStorageAccountKey("7sNosUyeNVFTkzf8WgikSms7vd8og866v/bRRIJt92zatVsrnL1TePgjx/trGLSCGAiM+nPEaSxJjWOAdPG3Ag==");
        this.setContainerName("app-container");
    }

    public void put(byte[] b){
        
        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder().tenantId("xxxx").clientId("xxxx").clientSecret("xxxx").build();
        BlobContainerClient containerClient = new BlobContainerClientBuilder().endpoint("https://testingapplication.blob.core.windows.net").containerName("app-container").credential(clientSecretCredential).buildClient();
        BlobClient blobClient = containerClient.getBlobClient("blobName");
        blobClient.uploadFromFile("C:/DP/RE_ Quote for MR Kloud from TLFC.pdf");
        //System.out.println(blobClient.downloadContent());
        //tokenContext.addScopes(new ArrayList<String>().add("Subscription"));
        //TokenCredential tokenCredential = 
        //BlobServiceClient client = new BlobServiceClientBuilder().;
//        props.setContainer
    }

    
}

