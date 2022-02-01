import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.c;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class albq
  extends alcb
{
  public albq(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetPersonalityLabelPhotos : isSuccess = ").append(paramBoolean).append(", uin = ").append(paramString).append(", labelId = ").append(paramLong).append(", completeFlag = ").append(paramInt).append(", cookie = ");
      if (paramArrayOfByte == null)
      {
        localObject = "null";
        localStringBuilder = localStringBuilder.append(localObject).append(", labelInfo = ");
        if (paramPersonalityLabelInfo != null) {
          break label313;
        }
        localObject = "null";
        label89:
        QLog.i("PersonalityLabelGalleryActivity", 2, (String)localObject);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(PersonalityLabelGalleryActivity.a(this.this$0))) {
        break label323;
      }
    }
    label313:
    label323:
    for (boolean bool = this.this$0.app.getCurrentAccountUin().equals(paramString);; bool = PersonalityLabelGalleryActivity.a(this.this$0).equals(paramString))
    {
      if (bool) {
        PersonalityLabelGalleryActivity.a(this.this$0, false);
      }
      if ((paramBoolean) && (paramPersonalityLabelInfo != null))
      {
        paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.this$0).get(Long.valueOf(paramLong));
        if (paramString != null)
        {
          if (PersonalityLabelGalleryActivity.b(this.this$0).get(Long.valueOf(paramLong)) == null)
          {
            paramString.personalityLabelPhotos.clear();
            if (PersonalityLabelGalleryActivity.a(this.this$0)) {
              paramPersonalityLabelInfo.photoCount = (this.this$0.a.a(paramLong, paramPersonalityLabelInfo, true) + paramPersonalityLabelInfo.photoCount);
            }
          }
          paramString.personalityLabelPhotos.addAll(paramPersonalityLabelInfo.personalityLabelPhotos);
          PersonalityLabelGalleryActivity.c(this.this$0).put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
          if (paramArrayOfByte != null) {
            PersonalityLabelGalleryActivity.b(this.this$0).put(Long.valueOf(paramLong), paramArrayOfByte);
          }
          PersonalityLabelGalleryActivity.a(this.this$0, paramLong);
        }
      }
      return;
      localObject = paramArrayOfByte;
      break;
      localObject = paramPersonalityLabelInfo.toString();
      break label89;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt != 1) {}
    label36:
    label167:
    label169:
    label192:
    do
    {
      return;
      boolean bool;
      if (TextUtils.isEmpty(PersonalityLabelGalleryActivity.a(this.this$0)))
      {
        bool = this.this$0.app.getCurrentAccountUin().equals(paramString);
        if (!bool) {
          break label167;
        }
        if ((!paramBoolean) || (paramPersonalityLabel == null)) {
          continue;
        }
        if (!this.this$0.cvS) {
          break label192;
        }
        this.this$0.bs.clear();
        if (PersonalityLabelGalleryActivity.a(this.this$0) != null) {
          break label169;
        }
      }
      for (paramInt = 0;; paramInt = PersonalityLabelGalleryActivity.a(this.this$0).getSize())
      {
        int i = paramPersonalityLabel.getSize();
        int j = 0;
        i -= paramInt;
        paramInt = j;
        while (i > 0)
        {
          this.this$0.bs.add(Long.valueOf(((PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(paramInt)).id));
          i -= 1;
          paramInt += 1;
        }
        bool = PersonalityLabelGalleryActivity.a(this.this$0).equals(paramString);
        break label36;
        break;
      }
      this.this$0.cvS = false;
      if ((paramPersonalityLabel.getSize() > 0) && (PersonalityLabelGalleryActivity.a(this.this$0)))
      {
        paramInt = 0;
        while (paramInt < paramPersonalityLabel.personalityLabelInfos.size())
        {
          paramString = (PersonalityLabelInfo)paramPersonalityLabel.personalityLabelInfos.get(paramInt);
          this.this$0.a.a(paramString.id, paramString, true);
          paramInt += 1;
        }
      }
      this.this$0.b(paramPersonalityLabel, true);
      if (this.this$0.mSubHandler.hasMessages(0)) {
        this.this$0.mSubHandler.removeMessages(0);
      }
      paramString = this.this$0.mSubHandler.obtainMessage(0, paramPersonalityLabel);
      this.this$0.mSubHandler.sendMessageDelayed(paramString, 500L);
      return;
    } while (paramBoolean);
    if (!aqiw.isNetSupport(this.this$0))
    {
      PersonalityLabelGalleryActivity.a(this.this$0, this.this$0.getResources().getString(2131696270));
      paramString = this.this$0;
      if ((PersonalityLabelGalleryActivity.a(this.this$0) == null) || (PersonalityLabelGalleryActivity.a(this.this$0).getSize() <= 0)) {
        break label427;
      }
    }
    label427:
    for (paramInt = 8;; paramInt = 0)
    {
      paramString.x(paramInt, "加载失败", false);
      return;
      PersonalityLabelGalleryActivity.a(this.this$0, this.this$0.getResources().getString(2131695453));
      break;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onDelPersonalityLabelPhoto suc:" + paramBoolean + "," + paramString + "," + paramLong1 + "," + paramLong2);
    }
    if ((PersonalityLabelGalleryActivity.a(this.this$0)) && (paramString.equals(this.this$0.app.getCurrentAccountUin())))
    {
      paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.this$0).get(Long.valueOf(paramLong1));
      if (paramString != null) {
        break label109;
      }
    }
    for (;;)
    {
      return;
      label109:
      int i = 0;
      while (i < paramString.personalityLabelPhotos.size())
      {
        if (((PersonalityLabelPhoto)paramString.personalityLabelPhotos.get(i)).fileId == paramLong2)
        {
          if (paramString.personalityLabelPhotos.remove(i) != null)
          {
            PersonalityLabelGalleryActivity.b(this.this$0, true);
            paramString.photoCount -= 1;
            this.this$0.aw(paramLong1, false);
          }
          PersonalityLabelGalleryActivity.a(this.this$0).notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albq
 * JD-Core Version:    0.7.0.1
 */