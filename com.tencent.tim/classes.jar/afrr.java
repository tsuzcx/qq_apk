import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class afrr
  extends afrl
{
  public afmi j;
  
  public afrr(afmi paramafmi)
  {
    this.j = paramafmi;
  }
  
  public afmi a()
  {
    return this.j;
  }
  
  public CustomEmotionData a()
  {
    if (((this.j instanceof afpg)) && (((afpg)this.j).bnT != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((afhu)((QQAppInterface)localObject).getManager(149)).ez();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((afpg)this.j).bnT.equalsIgnoreCase(localCustomEmotionData.resid)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(afrl paramafrl)
  {
    boolean bool = true;
    if ((paramafrl instanceof afrr))
    {
      paramafrl = ((afrr)paramafrl).j;
      Object localObject;
      if (((paramafrl instanceof afpg)) && ((this.j instanceof afpg)))
      {
        paramafrl = ((afpg)paramafrl).bnT;
        localObject = ((afpg)this.j).bnT;
        return (paramafrl != null) && (paramafrl.equals(localObject));
      }
      if (((paramafrl instanceof afpu)) && ((this.j instanceof afpu)))
      {
        paramafrl = ((afpu)paramafrl).e;
        localObject = ((afpu)this.j).e;
        if ((paramafrl != null) && (localObject != null) && (paramafrl.eId != null) && (paramafrl.eId.equals(((Emoticon)localObject).eId)) && (paramafrl.epId != null) && (paramafrl.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public boolean ajO()
  {
    return this.j instanceof afpu;
  }
  
  public boolean ajP()
  {
    return true;
  }
  
  public boolean ajQ()
  {
    return false;
  }
  
  public boolean ajR()
  {
    return false;
  }
  
  public afrl b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_emotion_id"))
    {
      QLog.d("FavEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      int i = paramBundle.getInt("cur_emotion_type");
      int k = paramBundle.getInt("cur_emotion_id");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface))
      {
        paramBundle = (QQAppInterface)paramBundle;
        if (i == 1) {}
        for (i = 333;; i = 149)
        {
          paramBundle = (affx)paramBundle.getManager(i);
          Object localObject = paramBundle.ez();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break;
          }
          localObject = ((List)localObject).iterator();
          CustomEmotionBase localCustomEmotionBase;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
          } while (localCustomEmotionBase.emoId != k);
          return new afrr(paramBundle.a(localCustomEmotionBase));
        }
      }
    }
    return null;
  }
  
  public void b(Bundle paramBundle, int paramInt)
  {
    super.b(paramBundle, paramInt);
    paramBundle.putInt("cur_emotion_id", (int)getUniqueId());
    if ((this.j instanceof aflv)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public Drawable e(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.j instanceof afpu)) {
      localURLDrawable = ((afpu)this.j).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.j instanceof afpg)) {
        return ((afpg)this.j).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.j instanceof aflv));
    return ((aflv)this.j).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public long getUniqueId()
  {
    if ((this.j instanceof afpn)) {
      return ((afpn)this.j).Dg();
    }
    return 0L;
  }
  
  public int t(List<afrl> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (afrl)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof afrr))
      {
        localObject1 = ((afrr)localObject1).j;
        if ((!(localObject1 instanceof afpg)) || (!(this.j instanceof afpg))) {
          break label133;
        }
        localObject2 = ((afpg)localObject1).url;
        String str = ((afpg)this.j).url;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((afpg)localObject1).path;
          localObject2 = ((afpg)this.j).path;
        } while ((localObject1 != null) && (((String)localObject1).equals(localObject2)));
      }
      label133:
      label203:
      do
      {
        do
        {
          i += 1;
          break;
          if ((!(localObject1 instanceof afpu)) || (!(this.j instanceof afpu))) {
            break label203;
          }
          localObject1 = ((afpu)localObject1).e;
          localObject2 = ((afpu)this.j).e;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof aflv)) || (!(this.j instanceof aflv)) || (((aflv)localObject1).emoId != ((aflv)this.j).emoId));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrr
 * JD-Core Version:    0.7.0.1
 */