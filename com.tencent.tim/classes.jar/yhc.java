import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class yhc
  extends ygi
{
  private Collection<String> b;
  
  public yhc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public List<? extends ygl> ad(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    ajdg localajdg = (ajdg)this.mApp.getManager(14);
    Object localObject = (afhu)this.mApp.getManager(149);
    yhf localyhf = yhf.a(this.mApp);
    localObject = ((afhu)localObject).ez();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticonDataList.size : " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
        if (("isUpdate".equals(localCustomEmotionData.RomaingType)) || ("needDownload".equals(localCustomEmotionData.RomaingType)) || ("overflow".equals(localCustomEmotionData.RomaingType)) || ("overflow_downloaded".equals(localCustomEmotionData.RomaingType))) {
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localyhf.hE(localCustomEmotionData.modifyWord))))
          {
            localArrayList.add(new yhb(this.mApp, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localyhf.hE(localCustomEmotionData.ocrWord))))
          {
            localArrayList.add(new yhb(this.mApp, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localajdg.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localyhf.hE(localEmoticon.name)))) {
              localArrayList.add(new yhb(this.mApp, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + aqft.pk(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public void cii()
  {
    this.b = yhf.a(this.mApp).e();
  }
  
  public boolean s(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.b == null) {
      cii();
    }
    return (this.b != null) && (this.b.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhc
 * JD-Core Version:    0.7.0.1
 */