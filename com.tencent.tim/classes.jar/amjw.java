import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

class amjw
  implements amju.a
{
  amjw(amju paramamju, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo) {}
  
  public void dNZ()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    String str = localSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    acnm localacnm = new acnm(localQQAppInterface);
    if (!TextUtils.equals(str, this.a.hotSearchGifID))
    {
      localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_try_id", this.a.hotSearchGifID).apply();
      localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", 1).apply();
      localacnm.d(localQQAppInterface, "gif_sta_first", null, null, this.a.hotSearchGifID);
      return;
    }
    localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", i + 1).apply();
    localacnm.d(localQQAppInterface, "gif_sta_second", null, null, this.a.hotSearchGifID);
  }
  
  public void dOa()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    acnm localacnm = new acnm(localQQAppInterface);
    if (i == 1) {
      localacnm.d(localQQAppInterface, "gif_suc_first", null, null, this.a.hotSearchGifID);
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_last_show_id", this.a.hotSearchGifID).apply();
      return;
      localacnm.d(localQQAppInterface, "gif_suc_second", null, null, this.a.hotSearchGifID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjw
 * JD-Core Version:    0.7.0.1
 */