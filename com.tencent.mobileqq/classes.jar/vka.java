import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager.LightReplyEmotionClickListener;
import java.util.HashMap;

public class vka
  implements LightReplyMenuManager.LightReplyEmotionClickListener
{
  public vka(AIOGalleryScene paramAIOGalleryScene, TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2, LightReplyEmojs paramLightReplyEmojs)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.put(paramInt1 + paramString + paramLong, paramLightReplyEmojs);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramInt1, paramString, paramLong, paramInt2, paramLightReplyEmojs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vka
 * JD-Core Version:    0.7.0.1
 */