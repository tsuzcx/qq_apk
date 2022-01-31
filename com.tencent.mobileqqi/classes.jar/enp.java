import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class enp
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  
  public enp(SendPhotoActivity paramSendPhotoActivity)
  {
    paramSendPhotoActivity = paramSendPhotoActivity.getIntent();
    this.jdField_a_of_type_Int = paramSendPhotoActivity.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Boolean = paramSendPhotoActivity.getBooleanExtra("PicContants.NEED_COMPRESS", true);
    this.jdField_b_of_type_Boolean = paramSendPhotoActivity.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_b_of_type_Int = paramSendPhotoActivity.getIntExtra("uintype", 1003);
    Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "initPicUploadInfos", "curType:" + this.jdField_b_of_type_Int + ",businessType:" + this.jdField_a_of_type_Int + ",needCompress:" + this.jdField_a_of_type_Boolean);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((localObject == null) || ("".equals(localObject)))
      {
        Logger.b(this, "handlePhoto", "path invalid,path:" + (String)localObject);
      }
      else
      {
        paramVarArgs.putExtra("PhotoConst.PHOTO_SEND_PATH", (String)localObject);
        PicReq localPicReq = PicBusiManager.a(1, this.jdField_a_of_type_Int);
        localPicReq.a(PicBusiManager.a(this.jdField_a_of_type_Int, paramVarArgs));
        this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = PicBusiManager.a(0, this.jdField_a_of_type_Int);
          CompressInfo localCompressInfo = PicBusiManager.a(this.jdField_a_of_type_Int, paramVarArgs);
          ((PicReq)localObject).a(localPicReq.jdField_a_of_type_JavaLangString);
          ((PicReq)localObject).a(localCompressInfo);
          PicBusiManager.a((PicReq)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_b_of_type_JavaUtilArrayList.add(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
          this.jdField_b_of_type_JavaUtilArrayList.add(localCompressInfo);
          if (localCompressInfo.jdField_e_of_type_Boolean)
          {
            localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = 1;
            Logger.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
          }
          else
          {
            localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a();
          }
        }
        else
        {
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_b_of_type_JavaUtilArrayList.add(localObject);
        }
      }
    }
    long l = System.currentTimeMillis();
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      PicBusiManager.a((PicReq)localIterator.next(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Logger.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
    SendPhotoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity);
    SendPhotoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity, paramVarArgs);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.d();
      label12:
      paramVoid = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.getIntent();
      paramVoid.putExtra(AlbumConstants.i, 2);
      if (!paramVoid.hasExtra("extra_image_sender_tag")) {
        paramVoid.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.getIntent());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.finish();
      if (!this.jdField_b_of_type_Boolean)
      {
        String str = paramVoid.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramVoid.setClassName(paramVoid.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), str);
        paramVoid.addFlags(603979776);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.startActivity(paramVoid);
      }
      Utils.a(BaseApplication.getContext(), this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception paramVoid)
    {
      break label12;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.a(2131562664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     enp
 * JD-Core Version:    0.7.0.1
 */