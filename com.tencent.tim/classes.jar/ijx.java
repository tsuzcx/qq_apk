import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.av.business.manager.magicface.MagicfaceDataMultiResultJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.json.JSONException;
import org.json.JSONObject;

public class ijx
  extends MagicFaceDataEntity
{
  protected MagicfaceDataMultiResultJason a;
  Rect af;
  int mResult = 0;
  
  public ijx(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramVideoAppInterface, paramString1, paramString2, paramString3, paramBoolean, paramInt);
    try
    {
      paramVideoAppInterface = new JSONObject(paramString3);
      if (paramVideoAppInterface.has("multiresult")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = ((MagicfaceDataMultiResultJason)aqec.convertFrom(paramVideoAppInterface.getJSONObject("multiresult"), MagicfaceDataMultiResultJason.class));
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason == null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason = new MagicfaceDataMultiResultJason();
      }
      igd.aL("MagicFaceDataEntityMultiResult", "multi: " + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.toString());
      this.af = new Rect(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_wid, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_hei);
      if (((paramBoolean) && (this.c.get(1))) || ((!paramBoolean) && (this.c.get(0))))
      {
        paramBoolean = true;
        this.RQ = paramBoolean;
        igd.aJ("MagicFaceDataEntityMultiResult", "MagicFaceDataEntityMultiResult constructor:");
        return;
      }
    }
    catch (JSONException paramVideoAppInterface)
    {
      for (;;)
      {
        paramVideoAppInterface.printStackTrace();
        continue;
        paramBoolean = false;
      }
    }
  }
  
  private String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason, String paramString)
  {
    String str = paramString;
    if (paramMagicfaceDataPendantJason != null)
    {
      str = paramString;
      if (paramMagicfaceDataPendantJason.mirror)
      {
        str = paramString;
        if (!this.RR) {
          str = paramString + "_mirror";
        }
      }
    }
    return str;
  }
  
  private void c(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int j;
    float f1;
    if (paramBoolean)
    {
      i = 4;
      j = i * 64 * 2;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= j) || (this.af == null)) {
        break label291;
      }
      igd.aJ("MagicFaceDataEntityMultiResult", "isShot:" + this.mResult + "|" + this.anW + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start + "|" + this.af.toString() + "|" + paramArrayOfByte.length);
      if ((this.mResult == 0) && (this.anW >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start - 2) && (this.anW < this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start))
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        if (!paramBoolean) {
          break label265;
        }
        f1 = paramArrayOfByte.getInt(j) / 1000000;
        label170:
        if (!paramBoolean) {
          break label276;
        }
      }
    }
    label265:
    label276:
    for (float f2 = paramArrayOfByte.getInt(j + i) / 1000000;; f2 = paramArrayOfByte.getShort(j + i))
    {
      igd.aJ("MagicFaceDataEntityMultiResult", "onReceiveFaceFeature Kill is:|" + f1 + "|" + f2 + "|" + this.af.toString());
      if (this.af.contains((int)f1, (int)f2)) {
        this.mResult = 1;
      }
      return;
      i = 2;
      break;
      f1 = paramArrayOfByte.getShort(j);
      break label170;
    }
    label291:
    igd.aJ("MagicFaceDataEntityMultiResult", "isShot ERROR");
  }
  
  private String getResult()
  {
    switch (this.mResult)
    {
    default: 
      return null;
    case 0: 
      return "miss";
    }
    return "hit";
  }
  
  private int kS()
  {
    switch (this.mResult)
    {
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_hit_frame;
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_miss_frame;
  }
  
  private String r(int paramInt1, int paramInt2)
  {
    igd.aJ("MagicFaceDataEntityMultiResult", " getResultString:" + paramInt2 + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start);
    switch (paramInt2)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_hit;
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_miss;
  }
  
  private boolean tx()
  {
    return (this.c.get(1)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.tips));
  }
  
  public String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    String str2 = super.a(paramMagicfaceDataPendantJason);
    igd.aJ("MagicFaceDataEntityMultiResult", "getDecorateName :" + paramMagicfaceDataPendantJason.toString());
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(paramMagicfaceDataPendantJason.trigger)) {
        break label142;
      }
      str1 = getResult();
      igd.aJ("MagicFaceDataEntityMultiResult", "getDecorateName 2:" + paramMagicfaceDataPendantJason.trigger + "|" + str1);
      if (!paramMagicfaceDataPendantJason.trigger.equals(str1)) {
        break label137;
      }
      str1 = a(paramMagicfaceDataPendantJason, str2);
    }
    for (;;)
    {
      igd.aJ("MagicFaceDataEntityMultiResult", "getDecorateName 3:" + str1);
      return str1;
      label137:
      str1 = null;
      continue;
      label142:
      str1 = a(paramMagicfaceDataPendantJason, str2);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    super.a(paramString, paramArrayOfByte, paramShort1, paramShort2, paramShort3, paramShort4, paramBoolean);
    if (this.c.get(0)) {
      if (!E(paramString)) {
        c(paramArrayOfByte, paramBoolean);
      }
    }
    while (!E(paramString)) {
      return;
    }
    c(paramArrayOfByte, paramBoolean);
  }
  
  public String aI(int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id))
    {
      int i = kR();
      igd.aJ("MagicFaceDataEntityMultiResult", " getResPath:" + paramInt + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start + "|" + i);
      if ((paramInt >= this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataMultiResultJason.divers_ani_start) && (paramInt < i)) {
        return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id + "_" + r(paramInt, this.mResult) + gM();
      }
      return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.common_id + gM();
    }
    return super.aI(paramInt);
  }
  
  public void ani()
  {
    super.ani();
    if (this.c.get(0)) {
      ig(true);
    }
    igd.aJ("MagicFaceDataEntityMultiResult", "processStart:" + this.c.get(2));
    if ((!this.c.get(2)) && (tx())) {
      showTips(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.tips);
    }
  }
  
  public void anj()
  {
    super.anj();
    if (this.c.get(0)) {
      ig(false);
    }
    kL(0);
    kL(1);
    if (tx()) {
      showTips(null);
    }
  }
  
  protected String gM()
  {
    String str = "";
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes)
    {
      str = "" + "_";
      localStringBuilder = new StringBuilder().append(str);
      if (!this.RQ) {
        break label120;
      }
    }
    label120:
    for (str = "mirror";; str = "normal")
    {
      str = str;
      igd.aJ("MagicFaceDataEntityMultiResult", "getMirrorPath:" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasMirrorRes + "|" + this.RQ + "|" + str);
      return str;
    }
  }
  
  public int kR()
  {
    return super.kR() + kS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijx
 * JD-Core Version:    0.7.0.1
 */