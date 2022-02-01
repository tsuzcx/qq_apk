import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class yhe
  extends ygi
{
  public yhe(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<yhd> af(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
    }
    ajdg localajdg = (ajdg)this.mApp.getManager(14);
    List localList = localajdg.f(paramString, true);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + aqft.pk(paramString));
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (Emoticon)localList.get(i);
      EmoticonPackage localEmoticonPackage = localajdg.b(((Emoticon)localObject).epId);
      if (localEmoticonPackage == null) {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons emoticonPackage is null.");
        }
      }
      label225:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((localajdg.CR == null) || (!localajdg.CR.contains(((Emoticon)localObject).epId)) || (localEmoticonPackage.status != 2)) {
            break label225;
          }
          localArrayList.add(new yhd((Emoticon)localObject));
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("findLocalMatchEmoticons emoticonPackage not match, status: ").append(localEmoticonPackage.status).append(" tabCache.size: ");
      if (localajdg.CR != null) {}
      for (int j = localajdg.CR.size();; j = -1)
      {
        QLog.d("StickerRecLocalEmoticonHandleListener", 2, j);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + localArrayList.size() + ",keyWord: " + aqft.pk(paramString));
    }
    return localArrayList;
  }
  
  public List<yhd> ad(String paramString)
  {
    return af(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhe
 * JD-Core Version:    0.7.0.1
 */