import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TargetApi(14)
public class pnj
{
  private long Ah;
  public pni a;
  protected pnj.a a;
  public pnj.b a;
  protected pnj.c a;
  private boolean aaY;
  protected List<StoryVideoItem> mk = new ArrayList();
  protected List<png> ml = new ArrayList();
  protected List<String> mm = new ArrayList();
  
  public pnj()
  {
    this.jdField_a_of_type_Pni = new pnp();
    this.jdField_a_of_type_Pnj$b = new pnj.b();
    this.jdField_a_of_type_Pni.vP(0);
    this.jdField_a_of_type_Pni.a(this.jdField_a_of_type_Pnj$b);
  }
  
  private boolean isWifi()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.Ah) > 5000L)
    {
      this.Ah = l;
      this.aaY = aqiw.isWifiConnected(BaseApplicationImpl.getContext());
    }
    return this.aaY;
  }
  
  public void a(pnj.c paramc)
  {
    this.jdField_a_of_type_Pnj$c = paramc;
  }
  
  public void dV(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mk = new ArrayList(paramList);
  }
  
  protected boolean eX(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
  
  public String fN(String paramString)
  {
    this.jdField_a_of_type_Pnj$a = new pnj.a(paramString);
    paramString = g(paramString, qln.a(BaseApplicationImpl.getContext()).JT());
    rW(true);
    return paramString;
  }
  
  protected String g(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((!this.mm.isEmpty()) && (this.mm.contains(paramString)))
    {
      QQStoryContext.a();
      paramString = rnw.a(QQStoryContext.a(), paramString);
      if (!(paramString instanceof MessageForShortVideo)) {
        break label141;
      }
    }
    label141:
    for (paramString = (MessageForShortVideo)paramString;; paramString = null)
    {
      Object localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = ShortVideoUtils.a(paramString, "mp4");
        if (!rox.fileExistsAndNotEmpty(paramString)) {
          break label77;
        }
        localObject1 = paramString;
      }
      label77:
      do
      {
        do
        {
          return localObject1;
          paramString = null;
          break;
          if (eX(paramString))
          {
            localObject1 = pnh.a(paramString, 0, paramBoolean, paramBoolean);
            if (localObject1 != null) {
              return ((File)localObject1).getAbsolutePath();
            }
          }
          localObject1 = localObject2;
        } while (!StoryVideoItem.isFakeVid(paramString));
        paramString = ((psu)psx.a(5)).a(paramString);
        localObject1 = localObject2;
      } while (paramString == null);
      return paramString.mLocalVideoPath;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Pni.stop();
    this.jdField_a_of_type_Pnj$c = null;
  }
  
  protected void rW(boolean paramBoolean)
  {
    pnk localpnk = new pnk(this, "Q.qqstory.download.preload.PlayingListPreloader", paramBoolean);
    localpnk.setJobType(4);
    Bosses.get().postJob(localpnk);
  }
  
  protected void rX(boolean paramBoolean)
  {
    List localList1 = this.mk;
    String str;
    List localList2;
    int k;
    label33:
    ArrayList localArrayList;
    int i;
    label52:
    int j;
    if (this.jdField_a_of_type_Pnj$a == null)
    {
      str = "";
      localList2 = this.mm;
      if (!isWifi()) {
        break label334;
      }
      k = 3;
      localArrayList = new ArrayList();
      if (TextUtils.isEmpty(str)) {
        break label473;
      }
      i = 0;
      if (i >= localList1.size()) {
        break label468;
      }
      if (!TextUtils.equals(((StoryVideoItem)localList1.get(i)).mVid, str)) {
        break label340;
      }
      j = 1;
    }
    for (;;)
    {
      if (j == 0) {
        i = 0;
      }
      j = i;
      i = 0;
      for (;;)
      {
        int m = i;
        Object localObject;
        label151:
        png localpng1;
        if (j < localList1.size())
        {
          localObject = (StoryVideoItem)localList1.get(j);
          if ((localList2.isEmpty()) || (!localList2.contains(((StoryVideoItem)localObject).mVid))) {
            break label347;
          }
          paramBoolean = true;
          if (!TextUtils.equals(str, ((StoryVideoItem)localObject).mVid)) {
            break label373;
          }
          localpng1 = png.a(((StoryVideoItem)localObject).mVid, 1);
          png localpng2 = png.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localObject = png.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean);
          localpng1.priority = 0;
          localpng2.priority = 0;
          ((png)localObject).priority = 1;
          localArrayList.add(localpng1);
          if (qln.a(BaseApplicationImpl.getContext()).JT()) {
            break label352;
          }
          localArrayList.add(localpng2);
          localpng2.fD.put("handleCallback", Boolean.valueOf(true));
          label267:
          localArrayList.add(localObject);
        }
        for (;;)
        {
          i += 1;
          if (i < k) {
            break label461;
          }
          m = i;
          ram.b("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(m));
          this.ml = localArrayList;
          this.jdField_a_of_type_Pni.w(localArrayList, true);
          return;
          str = this.jdField_a_of_type_Pnj$a.vid;
          break;
          label334:
          k = 2;
          break label33;
          label340:
          i += 1;
          break label52;
          label347:
          paramBoolean = false;
          break label151;
          label352:
          localpng1.fD.put("handleCallback", Boolean.valueOf(true));
          break label267;
          label373:
          localArrayList.add(png.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean));
          localArrayList.add(png.a(((StoryVideoItem)localObject).mVid, 1));
          localpng1 = png.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localpng1.fD.put("handleCallback", Boolean.valueOf(true));
          localArrayList.add(localpng1);
          localArrayList.add(localpng1);
        }
        label461:
        j += 1;
      }
      label468:
      j = 0;
      continue;
      label473:
      j = 0;
      i = 0;
    }
  }
  
  public static class a
  {
    public boolean aAO;
    public int errorCode = 1000;
    public String errorMsg = "";
    public final long id;
    public final String vid;
    
    public a(String paramString)
    {
      this.vid = paramString;
      this.id = System.currentTimeMillis();
    }
    
    public ErrorMessage a()
    {
      return new ErrorMessage(this.errorCode, this.errorMsg);
    }
  }
  
  class b
    extends pnn
  {
    public b()
    {
      super();
    }
    
    public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, png parampng)
    {
      super.a(paramString, paramInt1, paramErrorMessage, paramInt2, parampng);
      a(paramString, paramInt1, paramErrorMessage, parampng);
    }
    
    protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, png parampng)
    {
      pnj.a locala = pnj.this.jdField_a_of_type_Pnj$a;
      if (locala == null) {}
      label14:
      label169:
      do
      {
        break label14;
        do
        {
          return;
        } while (!TextUtils.equals(paramString, locala.vid));
        if (paramErrorMessage.isFail()) {
          if (!TextUtils.isEmpty(locala.errorMsg)) {
            break label136;
          }
        }
        for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
        {
          locala.errorMsg = paramErrorMessage;
          locala.errorCode = (paramInt + 1000);
          if ((!parampng.fD.containsKey("handleCallback")) || (locala.aAO)) {
            break;
          }
          locala.aAO = true;
          if (!pnj.this.eX(paramString)) {
            break label169;
          }
          if (pnj.this.jdField_a_of_type_Pnj$c == null) {
            break;
          }
          pnj.this.jdField_a_of_type_Pnj$c.onSuccess(paramString, parampng.downloadUrl, paramInt);
          return;
        }
      } while (pnj.this.jdField_a_of_type_Pnj$c == null);
      label136:
      pnj.this.jdField_a_of_type_Pnj$c.a(paramString, parampng.downloadUrl, locala.a(), paramInt);
    }
    
    public void b(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
    {
      super.b(paramString, paramInt1, paramFile, paramInt2, parampng);
      a(paramString, paramInt1, new ErrorMessage(), parampng);
    }
    
    public void b(String paramString, int paramInt, png parampng)
    {
      super.b(paramString, paramInt, parampng);
      if ((pnj.this.jdField_a_of_type_Pnj$c != null) && ((paramInt == 0) || (paramInt == 1))) {
        pnj.this.jdField_a_of_type_Pnj$c.p(paramString, parampng.downloadUrl, paramInt);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt);
    
    public abstract void onSuccess(String paramString1, String paramString2, int paramInt);
    
    public abstract void p(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnj
 * JD-Core Version:    0.7.0.1
 */