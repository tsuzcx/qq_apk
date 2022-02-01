import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ygv
  extends ygi
{
  private Collection<String> b;
  
  public ygv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<ygu> ae(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (afhc)this.mApp.getManager(333);
    yhf localyhf = yhf.a(this.mApp);
    localObject = ((afhc)localObject).ez();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localyhf.hE(localCameraEmotionData.strContext)))) {
          localArrayList.add(new ygu(this.mApp, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + aqft.pk(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<ygu> ad(String paramString)
  {
    return ae(paramString);
  }
  
  public void cii()
  {
    this.b = yhf.a(this.mApp).c();
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
 * Qualified Name:     ygv
 * JD-Core Version:    0.7.0.1
 */