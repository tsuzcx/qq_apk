import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class akxq
  implements Comparable<akxq>
{
  public akxl a;
  public CompressInfo a;
  public xuj a;
  public akxy b;
  public akye b;
  public PicMessageExtraData b;
  public int bEW;
  public int busiType;
  public akxm c;
  public int dpE = -1;
  public int dpF;
  public int dpG = this.priority;
  public MessageForPic j;
  public String localUUID = xP();
  public String logTag;
  public int priority = 1;
  public ArrayList<akxm> yu;
  
  public static String xP()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public void NS(String paramString)
  {
    this.localUUID = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.localUUID = this.localUUID;
    }
    if (this.jdField_b_of_type_Akxy != null) {
      this.jdField_b_of_type_Akxy.localUUID = this.localUUID;
    }
    if (this.jdField_a_of_type_Akxl != null) {
      this.jdField_a_of_type_Akxl.localUUID = this.localUUID;
    }
  }
  
  public int a(akxq paramakxq)
  {
    if (this.priority < paramakxq.priority) {
      return -1;
    }
    if (this.priority > paramakxq.priority) {
      return 1;
    }
    return 0;
  }
  
  public boolean a(MessageForPic paramMessageForPic, akxl paramakxl)
  {
    if (paramakxl == null)
    {
      akxe.M("PIC_TAG_ERROR", this.localUUID, "bindReqObj", "downInfo == null");
      return false;
    }
    paramakxl.localUUID = this.localUUID;
    paramakxl.busiType = this.busiType;
    paramakxl.time = paramMessageForPic.time;
    paramakxl.bEnableEnc = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Akxl = paramakxl;
    int i;
    if (this.dpE == 5)
    {
      this.jdField_a_of_type_Akxl.protocol = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.logTag = akxe.l(this.jdField_a_of_type_Akxl.uinType, 0, i);
      this.j = paramMessageForPic;
      return true;
      if (this.dpE == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Akxl.protocol = "chatraw";
      }
      else
      {
        if (this.dpE == 6) {
          this.jdField_a_of_type_Akxl.protocol = "chatimg";
        }
        i = 1;
      }
    }
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {}
    do
    {
      return false;
      paramCompressInfo.localUUID = this.localUUID;
    } while (paramCompressInfo.srcPath == null);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    return true;
  }
  
  public void b(akye paramakye)
  {
    this.jdField_b_of_type_Akye = paramakye;
  }
  
  public boolean c(akxm paramakxm)
  {
    if (paramakxm == null)
    {
      akxe.M("PIC_TAG_ERROR", this.localUUID, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramakxm.jdField_b_of_type_Akxy != null)
    {
      paramakxm.jdField_b_of_type_Akxy.localUUID = this.localUUID;
      paramakxm.jdField_b_of_type_Akxy.busiType = this.busiType;
    }
    if (paramakxm.jdField_a_of_type_Akxl != null)
    {
      paramakxm.jdField_a_of_type_Akxl.localUUID = this.localUUID;
      paramakxm.jdField_a_of_type_Akxl.busiType = this.busiType;
    }
    this.c = paramakxm;
    int i = -1;
    if (paramakxm.jdField_b_of_type_Akxy != null) {
      i = paramakxm.jdField_b_of_type_Akxy.uinType;
    }
    this.logTag = akxe.l(i, 2, 1);
    return true;
  }
  
  public boolean c(akxy paramakxy)
  {
    if (paramakxy == null)
    {
      akxe.M("PIC_TAG_ERROR", this.localUUID, "bindReqObj", "upInfo == null");
      return false;
    }
    paramakxy.localUUID = this.localUUID;
    paramakxy.busiType = this.busiType;
    this.jdField_b_of_type_Akxy = paramakxy;
    this.logTag = akxe.l(this.jdField_b_of_type_Akxy.uinType, 1, 1);
    return true;
  }
  
  public void eF(ArrayList<akxm> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      akxe.M("PIC_TAG_ERROR", this.localUUID, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      akxm localakxm = (akxm)localIterator.next();
      if (localakxm != null)
      {
        if (localakxm.jdField_b_of_type_Akxy != null)
        {
          localakxm.jdField_b_of_type_Akxy.localUUID = this.localUUID;
          localakxm.jdField_b_of_type_Akxy.busiType = this.busiType;
        }
        if (localakxm.jdField_a_of_type_Akxl != null)
        {
          localakxm.jdField_a_of_type_Akxl.localUUID = this.localUUID;
          localakxm.jdField_a_of_type_Akxl.busiType = this.busiType;
        }
      }
    }
    this.yu = paramArrayList;
    this.logTag = akxe.l(((akxm)paramArrayList.get(0)).jdField_b_of_type_Akxy.uinType, 2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxq
 * JD-Core Version:    0.7.0.1
 */