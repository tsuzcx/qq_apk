import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TargetApi(14)
public class vmu
{
  private long jdField_a_of_type_Long;
  protected List<StoryVideoItem> a;
  public vms a;
  protected vmw a;
  public vmx a;
  protected vmy a;
  private boolean jdField_a_of_type_Boolean;
  protected List<vmp> b = new ArrayList();
  protected List<String> c = new ArrayList();
  
  public vmu()
  {
    this.jdField_a_of_type_Vms = new vnh();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vmx = new vmx(this);
    this.jdField_a_of_type_Vms.a(0);
    this.jdField_a_of_type_Vms.a(this.jdField_a_of_type_Vmx);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) > 5000L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Boolean = NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a(String paramString)
  {
    this.jdField_a_of_type_Vmw = new vmw(paramString);
    paramString = a(paramString, wvt.a(BaseApplicationImpl.getContext()).a());
    a(true);
    return paramString;
  }
  
  protected String a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((!this.c.isEmpty()) && (this.c.contains(paramString)))
    {
      QQStoryContext.a();
      paramString = yns.a(QQStoryContext.a(), paramString);
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
        paramString = ShortVideoUtils.getShortVideoSavePath(paramString, "mp4");
        if (!ypi.c(paramString)) {
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
          if (a(paramString))
          {
            localObject1 = vmq.a(paramString, 0, paramBoolean, paramBoolean);
            if (localObject1 != null) {
              return ((File)localObject1).getAbsolutePath();
            }
          }
          localObject1 = localObject2;
        } while (!StoryVideoItem.isFakeVid(paramString));
        paramString = ((vuu)vux.a(5)).a(paramString);
        localObject1 = localObject2;
      } while (paramString == null);
      return paramString.mLocalVideoPath;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vms.a();
    this.jdField_a_of_type_Vmy = null;
  }
  
  public void a(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
  
  public void a(vmy paramvmy)
  {
    this.jdField_a_of_type_Vmy = paramvmy;
  }
  
  protected void a(boolean paramBoolean)
  {
    vmv localvmv = new vmv(this, "Q.qqstory.download.preload.PlayingListPreloader", paramBoolean);
    localvmv.setJobType(4);
    Bosses.get().postJob(localvmv);
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
  
  protected void b(boolean paramBoolean)
  {
    List localList1 = this.jdField_a_of_type_JavaUtilList;
    String str;
    List localList2;
    int k;
    label33:
    ArrayList localArrayList;
    int i;
    label52:
    int j;
    if (this.jdField_a_of_type_Vmw == null)
    {
      str = "";
      localList2 = this.c;
      if (!a()) {
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
        vmp localvmp1;
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
          localvmp1 = vmp.a(((StoryVideoItem)localObject).mVid, 1);
          vmp localvmp2 = vmp.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localObject = vmp.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean);
          localvmp1.g = 0;
          localvmp2.g = 0;
          ((vmp)localObject).g = 1;
          localArrayList.add(localvmp1);
          if (wvt.a(BaseApplicationImpl.getContext()).a()) {
            break label352;
          }
          localArrayList.add(localvmp2);
          localvmp2.a.put("handleCallback", Boolean.valueOf(true));
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
          xvv.a("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(m));
          this.b = localArrayList;
          this.jdField_a_of_type_Vms.a(localArrayList, true);
          return;
          str = this.jdField_a_of_type_Vmw.a;
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
          localvmp1.a.put("handleCallback", Boolean.valueOf(true));
          break label267;
          label373:
          localArrayList.add(vmp.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean));
          localArrayList.add(vmp.a(((StoryVideoItem)localObject).mVid, 1));
          localvmp1 = vmp.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localvmp1.a.put("handleCallback", Boolean.valueOf(true));
          localArrayList.add(localvmp1);
          localArrayList.add(localvmp1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmu
 * JD-Core Version:    0.7.0.1
 */