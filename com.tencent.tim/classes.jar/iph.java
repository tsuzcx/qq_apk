import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class iph
{
  String PK = null;
  String PL = null;
  String PM = null;
  boolean TF = false;
  boolean TS = false;
  int arN = 0;
  int arO = 0;
  int arq = 0;
  int mHeight = 0;
  int mWidth = 0;
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, PendantItem paramPendantItem, ios paramios, int paramInt4)
  {
    String str;
    label34:
    label43:
    StringBuilder localStringBuilder;
    if ((paramFilterDesc == null) || (paramFilterDesc.name == null))
    {
      paramFilterDesc = "null";
      if ((paramPendantItem != null) && (paramPendantItem.getId() != null)) {
        break label522;
      }
      str = "null";
      if (paramVideoMaterial != null) {
        break label532;
      }
      paramVideoMaterial = "null";
      if ((paramInt1 != this.mWidth) || (paramInt2 != this.mHeight) || (paramInt3 != this.arq) || (paramBoolean != this.TS) || (this.arN != paramios.data.length) || (this.TF != paramios.TF) || (this.arO != paramInt4) || (!TextUtils.equals(paramFilterDesc, this.PK)) || (!TextUtils.equals(str, this.PL)) || (!TextUtils.equals(paramVideoMaterial, this.PM)))
      {
        localStringBuilder = new StringBuilder().append("RenderInfoLog, frameIndex[").append(paramLong).append("], width[").append(this.mWidth).append("->").append(paramInt1).append("], height[").append(this.mHeight).append("->").append(paramInt2).append("], angle[").append(this.arq).append("->").append(paramInt3).append("], needfacedata[").append(this.TS).append("->").append(paramBoolean).append("], mDataLen[").append(this.arN).append("->").append(paramios.data.length).append("], mBeautyLevel[").append(this.arO).append("->").append(paramInt4).append("], isFront[").append(this.TF).append("->").append(paramios.TF).append("], getFrameAngle[").append(ioz.j(paramios.TF)).append("], fAngle[").append((paramios.angle - ioz.j(paramios.TF) - 1 + 4) % 4).append("], strFilterDesc[").append(paramFilterDesc).append("], strPendantItem[").append(str).append("], pendantItem[");
        if ((paramPendantItem != null) && (paramPendantItem.getId() != null)) {
          break label542;
        }
      }
    }
    label522:
    label532:
    label542:
    for (paramPendantItem = "null";; paramPendantItem = paramPendantItem.getId())
    {
      QLog.w(paramString, 1, paramPendantItem + "], strFilters[" + paramVideoMaterial + "]");
      this.TF = paramios.TF;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.arq = paramInt3;
      this.TS = paramBoolean;
      this.PK = paramFilterDesc;
      this.PL = str;
      this.PM = paramVideoMaterial;
      this.arN = paramios.data.length;
      this.arO = paramInt4;
      return;
      paramFilterDesc = paramFilterDesc.name;
      break;
      str = paramPendantItem.getId();
      break label34;
      paramVideoMaterial = paramVideoMaterial.toString();
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iph
 * JD-Core Version:    0.7.0.1
 */