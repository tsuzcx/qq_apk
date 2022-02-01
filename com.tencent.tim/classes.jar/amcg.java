import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.1;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.2;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.3;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.4;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.5;

public class amcg
  extends xui.a
{
  public amcg(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.5(this, paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle));
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.2(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.1(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.3(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public void notifyFinish()
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcg
 * JD-Core Version:    0.7.0.1
 */