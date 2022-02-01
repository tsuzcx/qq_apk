import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class afhz
  extends afko
{
  afhz(afhv paramafhv) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.this$0.kg.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    afke localafke = (afke)afhv.l(this.this$0).getManager(43);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", afke.cRu);
      paramBundle = new File(afnu.bEu.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      afkz localafkz = new afkz();
      if (paramBundle.exists()) {}
      for (paramBundle = aqhq.fileToBytes(paramBundle);; paramBundle = null)
      {
        paramBundle = afkp.a(afhv.m(this.this$0), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localafkz);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        aqrm.b("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.this$0.a(paramEmoticonPackage, localafke, localArrayList, localafkz);
      this.this$0.a(paramEmoticonPackage, localafke);
      return;
    }
    this.this$0.d(paramEmoticonPackage);
    aqrm.b("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", aqiw.getNetworkType(afhv.n(this.this$0).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhz
 * JD-Core Version:    0.7.0.1
 */