import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.qwallet.elem.SkinRedPkgElem;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class upt
  implements PreloadManager.OnGetPathListener
{
  upt(ups paramups) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      if (this.a.a.skinType != 1) {
        break label373;
      }
      paramPathResult = paramPathResult + File.separator;
      localObject2 = paramPathResult + "corner.png";
      localObject1 = paramPathResult + "base_bg.png";
      str = paramPathResult + "anim_fg";
      paramInt = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      j = (int)(CustomizeStrategyFactory.a * 300.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      BitmapFactory.Options localOptions = ImageUtil.a((String)localObject2, paramInt);
      this.a.a.corner = SafeBitmapFactory.decodeFile((String)localObject2, localOptions);
      localObject2 = ImageUtil.a((String)localObject1, j);
      this.a.a.background = SafeBitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      this.a.a.animInfo = AnimationView.AnimationInfo.loadFromFolder(str);
      localObject1 = SkinRedPkgElem.a;
      j = localObject1.length;
      paramInt = 0;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        String str;
        int j;
        int i;
        label373:
        paramPathResult.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < j)
    {
      str = localObject1[paramInt];
      localObject2 = paramPathResult + str + ".png";
      localObject2 = SafeBitmapFactory.decodeFile((String)localObject2, ImageUtil.a((String)localObject2, i));
      if (localObject2 != null) {
        this.a.a.attribute.putParcelable(str, (Parcelable)localObject2);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.a.a.background + ",animInfo=" + this.a.a.animInfo);
      }
      for (;;)
      {
        CustomizeStrategyFactory.a().a(this.a.a);
        return;
        if (this.a.a.skinType == 2)
        {
          this.a.a.resPath = paramPathResult;
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_REDPACKET path=" + paramPathResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upt
 * JD-Core Version:    0.7.0.1
 */