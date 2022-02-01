import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afhy
  extends afkn
{
  afhy(afhv paramafhv) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.a(paramEmoticonPackage, paramInt);
    afkd.a().b(this.this$0.c);
    Object localObject = (afhu)afhv.i(this.this$0).getManager(149);
    ajdg localajdg = (ajdg)afhv.j(this.this$0).getManager(14);
    List localList = ((afhu)localObject).at(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localajdg.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((afhu)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        afhv localafhv = this.this$0;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localafhv.onFileDone(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (acef)afhv.k(this.this$0).getBusinessHandler(72);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((acef)localObject).ai(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhy
 * JD-Core Version:    0.7.0.1
 */