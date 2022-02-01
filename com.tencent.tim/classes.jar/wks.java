import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.e;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wks
  implements PreloadManager.d
{
  public wks(CustomizeStrategyFactory.e parame, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    Object localObject1 = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      if (this.val$info.skinType != 1) {
        break label345;
      }
      paramPathResult = (String)localObject1 + File.separator;
      str1 = paramPathResult + "corner.png";
      localObject2 = paramPathResult + "base_bg.png";
      String str2 = paramPathResult + "anim_fg";
      paramInt = (int)(CustomizeStrategyFactory.density * 50.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.density * 300.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.density * 50.0F + 0.5D);
      BitmapFactory.Options localOptions = aqhu.a(str1, paramInt);
      this.val$info.corner = SafeBitmapFactory.decodeFile(str1, localOptions);
      this.val$info.resPath = ((String)localObject1);
      this.val$info.background = ((String)localObject2);
      this.val$info.animInfo = AnimationView.AnimationInfo.loadFromFolder(str2);
      localObject1 = xwg.cK;
      j = localObject1.length;
      paramInt = 0;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        String str1;
        Object localObject2;
        int i;
        int j;
        label345:
        paramPathResult.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < j)
    {
      str1 = localObject1[paramInt];
      localObject2 = paramPathResult + str1 + ".png";
      localObject2 = SafeBitmapFactory.decodeFile((String)localObject2, aqhu.a((String)localObject2, i));
      if (localObject2 != null) {
        this.val$info.attribute.putParcelable(str1, (Parcelable)localObject2);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.val$info.background + ",animInfo=" + this.val$info.animInfo);
      }
      for (;;)
      {
        CustomizeStrategyFactory.a().b(this.val$info);
        return;
        if (this.val$info.skinType == 2)
        {
          this.val$info.resPath = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_REDPACKET path=" + (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */