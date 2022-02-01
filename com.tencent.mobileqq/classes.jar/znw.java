import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

public class znw
  implements ISuperPlayer.OnCompletionListener
{
  public znw(TribeVideoPlugin paramTribeVideoPlugin, zod paramzod) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(6, zod.a(this.jdField_a_of_type_Zod));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = zod.a(this.jdField_a_of_type_Zod);
      paramISuperPlayer.what = 6;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znw
 * JD-Core Version:    0.7.0.1
 */