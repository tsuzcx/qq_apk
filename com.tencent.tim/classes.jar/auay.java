import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.11;

public class auay
  extends smq.f
{
  public auay(TroopFileModel.11 param11) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramByteStringMicro1 = audx.e(paramByteStringMicro1);
    paramString2 = null;
    paramString1 = paramString2;
    if (paramBoolean)
    {
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramInt1 = this.a.g.zipType;
        paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramByteStringMicro1 + "&filetype=" + paramInt1 + "&path=" + aurr.encodeUrl(this.a.g.zipInnerPath) + "&";
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.a.a != null) {
        this.a.a.fO(paramString1, paramString4);
      }
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "url = " + paramString1 + ", cookies = " + paramString4);
      }
      if (this.a.this$0.c.b() != null)
      {
        paramString1 = String.valueOf(this.a.this$0.c.b().TroopUin);
        if (this.a.this$0.c.b() == null) {
          break label299;
        }
        paramString2 = audx.el(this.a.this$0.c.b().nFileType);
        label269:
        anot.a(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramString1, "", paramString2, "1");
      }
    }
    label299:
    do
    {
      return;
      paramString1 = "";
      break;
      paramString2 = "unknow";
      break label269;
      if (this.a.a != null) {
        this.a.a.djD();
      }
    } while (!QLog.isColorLevel());
    QLog.e("zivonchen", 2, "url = " + paramString1 + ", cookies = " + paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auay
 * JD-Core Version:    0.7.0.1
 */