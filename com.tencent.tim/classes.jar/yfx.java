import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class yfx
{
  public static volatile boolean NH;
  public static final String aXr = aqul.getSDKPrivatePath(acbn.bmw) + File.separator;
  public static final String aXs = aXr + "res/";
  public static final String aXt = aXr + "lottie/";
  public static final String aXu = aXr + "font/";
  public static final String aXv = aXr + "summary/";
  public static final String aXw = aXu + "sticker_bubble_animation.ttf";
  public static String aXx;
  public static volatile boolean bmo;
  public static SparseArray<String> bz = new SparseArray();
  public static Typeface mTypeface;
  public static ArrayList<yfw> qU = new ArrayList();
  
  public static yfw a(int paramInt)
  {
    if (qU.size() > paramInt) {
      return (yfw)qU.get(paramInt);
    }
    return null;
  }
  
  public static List<yfw> ac(String paramString)
  {
    if ((paramString != null) && (paramString.equals(aXx))) {
      return qU;
    }
    qU.clear();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              int k = Integer.parseInt(paramString[i]);
              yfw localyfw = new yfw();
              localyfw.pokeemoId = k;
              localyfw.localPath = cK(k);
              qU.add(localyfw);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    return qU;
  }
  
  public static yfw b(int paramInt)
  {
    Object localObject;
    yfw localyfw;
    if (qU.size() != 0)
    {
      localObject = qU.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localyfw = (yfw)((Iterator)localObject).next();
      } while (localyfw.pokeemoId != paramInt);
    }
    for (;;)
    {
      localObject = localyfw;
      if (localyfw == null)
      {
        localObject = new yfw();
        ((yfw)localObject).pokeemoId = paramInt;
        ((yfw)localObject).localPath = cK(paramInt);
      }
      return localObject;
      localyfw = null;
    }
  }
  
  public static String cJ(int paramInt)
  {
    if (bz.size() == 0) {
      chV();
    }
    String str2 = (String)bz.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131709420);
    }
    return str1;
  }
  
  public static String cK(int paramInt)
  {
    return String.format("%spe_%d.gif", new Object[] { aXs, Integer.valueOf(paramInt) });
  }
  
  public static void chV()
  {
    label162:
    for (;;)
    {
      Object localObject1;
      try
      {
        bool = NH;
        if (bool) {
          return;
        }
        localObject1 = new File(aXv);
        if (!((File)localObject1).exists()) {
          continue;
        }
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          continue;
        }
        localObject1 = localObject1[0];
      }
      finally {}
      try
      {
        localObject1 = aqhq.e((File)localObject1);
        if (localObject1 == null) {
          break label162;
        }
        localObject1 = new String((byte[])localObject1, "UTF-8");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject3 = null;
        continue;
        NH = true;
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = (String)((JSONObject)localObject1).get(str1);
            int i = Integer.parseInt(str1);
            bz.put(i, str2);
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static void chW()
  {
    if (mTypeface != null) {
      return;
    }
    try
    {
      File localFile = new File(aXw);
      if (localFile.exists()) {
        mTypeface = Typeface.createFromFile(localFile);
      }
      QLog.e("PokeEmo", 1, "loadFont success ");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PokeEmo", 1, "loadFont failed " + localException.getMessage());
      mTypeface = null;
      bmo = false;
    }
  }
  
  public static Drawable p(int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    String str = cK(paramInt);
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842311);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842311);
    localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfx
 * JD-Core Version:    0.7.0.1
 */