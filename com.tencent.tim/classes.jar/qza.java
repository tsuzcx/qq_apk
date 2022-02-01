import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class qza
{
  public pni a;
  protected qza.a a;
  public qza.b a;
  protected qza.c a;
  private Object bv = new Object();
  protected StoryVideoItem m;
  protected List<qwa> mFeedList = new ArrayList();
  protected List<png> ml = new ArrayList();
  
  public qza()
  {
    this.jdField_a_of_type_Pni = new pnp();
    this.jdField_a_of_type_Qza$b = new qza.b();
    this.jdField_a_of_type_Pni.vP(1);
    this.jdField_a_of_type_Pni.a(this.jdField_a_of_type_Qza$b);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<png> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      png localpng1 = png.a(paramStoryVideoItem.mVid, 1);
      png localpng2 = png.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = png.a(paramStoryVideoItem.mVid, 2);
      localpng1.priority = 0;
      localpng2.priority = 0;
      paramStoryVideoItem.priority = 1;
      localpng2.fD.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localpng1);
      paramList.add(localpng2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(png.a(paramStoryVideoItem.mVid, 2));
    paramList.add(png.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = png.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.fD.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<qwa> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new qzb(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(qza.c paramc)
  {
    this.jdField_a_of_type_Qza$c = paramc;
  }
  
  protected void brQ()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    for (;;)
    {
      synchronized (this.bv)
      {
        ((List)localObject2).addAll(this.mFeedList);
        if (this.m == null) {
          break label290;
        }
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label285;
        }
        List localList = ((qwa)((List)localObject2).get(i)).bZ();
        if ((localList.size() > 0) && (TextUtils.equals(this.m.mVid, ((StoryVideoItem)localList.get(0)).mVid)))
        {
          j = 1;
          a(this.m, localArrayList, true);
          if (j == 0)
          {
            i = 0;
            j = i + 1;
            if (j < ((List)localObject2).size())
            {
              ??? = ((qwa)((List)localObject2).get(j)).bZ();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((qwa)((List)localObject2).get(i)).bZ();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.ml = localArrayList;
            this.jdField_a_of_type_Pni.w(localArrayList, true);
          }
        }
        else
        {
          i += 1;
        }
      }
      continue;
      label285:
      int j = 0;
      continue;
      label290:
      j = 0;
      int i = 0;
    }
  }
  
  protected boolean eX(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Pni.stop();
    this.jdField_a_of_type_Qza$c = null;
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
      qza.a locala = qza.this.jdField_a_of_type_Qza$a;
      if (locala == null) {}
      label14:
      label168:
      do
      {
        break label14;
        do
        {
          return;
        } while (!TextUtils.equals(paramString, locala.vid));
        if (paramErrorMessage.isFail()) {
          if (!TextUtils.isEmpty(locala.errorMsg)) {
            break label135;
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
          if (!qza.this.eX(paramString)) {
            break label168;
          }
          if (qza.this.jdField_a_of_type_Qza$c == null) {
            break;
          }
          qza.this.jdField_a_of_type_Qza$c.onSuccess(paramString, parampng.downloadUrl);
          return;
        }
      } while (qza.this.jdField_a_of_type_Qza$c == null);
      label135:
      qza.this.jdField_a_of_type_Qza$c.a(paramString, parampng.downloadUrl, locala.a());
    }
    
    public void b(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
    {
      super.b(paramString, paramInt1, paramFile, paramInt2, parampng);
      a(paramString, paramInt1, new ErrorMessage(), parampng);
    }
    
    public void b(String paramString, int paramInt, png parampng)
    {
      super.b(paramString, paramInt, parampng);
      if ((qza.this.jdField_a_of_type_Qza$c != null) && ((paramInt == 0) || (paramInt == 1))) {
        qza.this.jdField_a_of_type_Qza$c.cx(paramString, parampng.downloadUrl);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage);
    
    public abstract void cx(String paramString1, String paramString2);
    
    public abstract void onSuccess(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qza
 * JD-Core Version:    0.7.0.1
 */