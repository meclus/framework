package org.mickey.framework.filemanager.api;

import org.junit.Before;
import org.junit.Test;
import org.mickey.framework.common.dto.ActionResult;
import org.mickey.framework.common.util.FileUtil;
import org.mickey.framework.common.util.UUIDUtils;
import org.mickey.framework.core.test.BaseSpringTest;
import org.mickey.framework.filemanager.client.FileClient;
import org.mickey.framework.filemanager.dto.PolicyRequestDto;
import org.mickey.framework.filemanager.dto.PolicyResultDto;
import org.mickey.framework.filemanager.dto.UploadCallbackDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

/**
 * description
 *
 * @author mickey
 * 2020-02-12
 */
public class FileControllerTest extends BaseSpringTest {

    @Autowired
    private FileCredentialController credentialController;
    @Autowired
    private FileUploadCallbackController callbackController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPolicy() {
        PolicyRequestDto requestDto = new PolicyRequestDto();
        requestDto.setAction("PutObject");
        ActionResult<PolicyResultDto> actionResult = credentialController.getPolicy(requestDto);

        print(actionResult);
    }

    @Test
    public void callback() {
        String fileId = UUIDUtils.getUuid();

        UploadCallbackDto uploadCallbackDto = new UploadCallbackDto();
        uploadCallbackDto.setBucket("asvinos001-1252065669");
        uploadCallbackDto.setEtag("FF808081702CFDCD01703483D0910013");
        uploadCallbackDto.setFileId(fileId);
        uploadCallbackDto.setFileName("WeChat Image_20200204154945.png");
        uploadCallbackDto.setFilePath("asvinos001-1252065669.cos.ap-chengdu.myqcloud.com/dev/haolun/null/95f05fe5621f4f299771759758ab7fb0/reportsource/20200211/FF808081702CFDCD01703483D0910013_WeChat%20Image_20200204154945.png");
        uploadCallbackDto.setMimeType("image/png");
        uploadCallbackDto.setSize(52353);
        uploadCallbackDto.setType(".png");

        ActionResult actionResult = callbackController.callback(uploadCallbackDto);

        print(actionResult);

        callbackController.delete(fileId);
    }

    @Test
    public void upload4Java() throws IOException {
        File file = new File("C:\\Users\\micke\\Pictures\\e2b_export_1.png");

        FileClient.updateByteFileToTemp("test_upload_java_file.png", FileUtil.getByteArray(file));
    }

    @Test
    public void downloadBasee64String() throws Exception {
        print(FileClient.downloadBase64String("https://asvinos001-1252065669.cos.ap-chengdu.myqcloud.com/dev/haolun/temp/test_upload_java_file.png"));
    }
}