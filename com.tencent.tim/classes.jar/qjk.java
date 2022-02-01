import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.j;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.b;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.f;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class qjk
  extends qjj
{
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  private final VideoViewVideoHolder.j jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$j;
  @NonNull
  public final XViewPager a;
  @NonNull
  final qjc jdField_a_of_type_Qjc;
  private final qjk.a jdField_a_of_type_Qjk$a;
  private final qjk.b jdField_a_of_type_Qjk$b;
  private qjr jdField_a_of_type_Qjr;
  private qjw jdField_a_of_type_Qjw;
  private qiw jdField_b_of_type_Qiw;
  private qjr jdField_b_of_type_Qjr;
  private Map<String, String> fT = new HashMap();
  private qgy.c g;
  @NonNull
  public final View itemView;
  private List<qgy.d> nS = new LinkedList();
  
  public qjk(@NonNull ViewGroup paramViewGroup)
  {
    this.itemView = paramViewGroup.findViewById(2131381896);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.itemView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.TAG = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Qjc = new qjc();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new qix(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new qjk.b(null);
    this.jdField_a_of_type_Qjk$b = ((qjk.b)localObject);
    qjk.c localc = new qjk.c(null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$j = localc;
    paramViewGroup.a((qiw)localObject, localc);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new qjk.a(null);
    this.jdField_a_of_type_Qjk$a = ((qjk.a)localObject);
    paramViewGroup.setOnPageChangeListener((XViewPager.f)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void k(@NonNull String paramString, @NonNull List<qgy.d> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      qgy.d locald = (qgy.d)localIterator.next();
      if (locald.JA()) {
        localArrayList.add(locald.d.groupId + "(Loading)");
      } else if (locald.Jz()) {
        localArrayList.add(locald.d.groupId + "(Error)");
      } else {
        localArrayList.add(locald.d.groupId + "(" + locald.nv.size() + ")");
      }
    }
    ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  public boolean Js()
  {
    if (this.jdField_a_of_type_Qjw != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Qjw.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.bmH = 2;
      }
    }
    rar.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Qjc.Js();
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    XViewPager.b localb = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localb != null) {
      return (StoryPlayerGroupHolder)localb.object;
    }
    return null;
  }
  
  public qgy.c a()
  {
    return this.g;
  }
  
  public void a(qgy.a parama, qgy.c paramc)
  {
    ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(parama.aDp), Boolean.valueOf(parama.aDq), parama.g, parama.h, Integer.valueOf(parama.nP.size()), paramc.groupId });
    this.g = paramc;
    ArrayList localArrayList = new ArrayList(parama.nP);
    k("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    qgy.d locald;
    while (((Iterator)localObject).hasNext())
    {
      locald = (qgy.d)((Iterator)localObject).next();
      String str = (String)this.fT.get(locald.d.groupId);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(locald.axq))
        {
          ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", locald.d.groupId, locald.axq);
          this.fT.put(locald.d.groupId, locald.axq);
        }
        else if (locald.nv.size() > 0)
        {
          ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", locald.d.groupId, locald.nv.get(0));
          this.fT.put(locald.d.groupId, locald.nv.get(0));
        }
        else
        {
          ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", locald.d.groupId, null);
          this.fT.put(locald.d.groupId, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!locald.nv.contains(str)))
      {
        ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", locald.d.groupId, str);
        this.fT.put(locald.d.groupId, null);
      }
    }
    this.jdField_a_of_type_Qjc.a(parama, paramc.groupId);
    int i;
    int j;
    int k;
    label469:
    int n;
    int m;
    label573:
    label617:
    int i2;
    label696:
    label743:
    int i3;
    label906:
    label931:
    label950:
    int i1;
    if (this.nS.isEmpty())
    {
      this.nS.addAll(parama.nP);
      i = 1;
      j = 1;
      k = 1;
      k("onBind, currentGroupInfoList", this.nS);
      localArrayList.clear();
      localArrayList.addAll(this.nS);
      n = 0;
      m = 0;
      if (i == 0) {
        break label1762;
      }
      ram.v("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (qgy.d)localArrayList.get(0) });
      if (parama.aDp) {
        break label1742;
      }
      if ((parama.g == null) || (parama.g.isSuccess()))
      {
        if ((this.jdField_a_of_type_Qjr != null) && (this.jdField_a_of_type_Qjr.JA())) {
          break label2052;
        }
        i = 1;
        this.jdField_a_of_type_Qjr = new qjr("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Qjr);
        if (j == 0) {
          break label1867;
        }
        ram.v("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (qgy.d)localArrayList.get(localArrayList.size() - 1) });
        if (parama.aDq) {
          break label1846;
        }
        if ((parama.h != null) && (!parama.h.isSuccess())) {
          break label1788;
        }
        if ((this.jdField_b_of_type_Qjr != null) && (this.jdField_b_of_type_Qjr.JA())) {
          break label2049;
        }
        i = 1;
        this.jdField_b_of_type_Qjr = new qjr("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.jdField_b_of_type_Qjr);
        j = i;
        k("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1893;
        }
        ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (qgy.d)localArrayList.get(0);
      i2 = this.nS.indexOf(localObject);
      localObject = (qgy.d)localArrayList.get(localArrayList.size() - 1);
      i3 = this.nS.indexOf(localObject);
      ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
      if (i2 == -1) {
        break label2094;
      }
      m = i2;
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      if (n >= localArrayList.size()) {
        break label2091;
      }
      if (m < this.nS.size())
      {
        localObject = (qgy.d)this.nS.get(m);
        locald = (qgy.d)localArrayList.get(n);
        if (locald == null) {
          break label1282;
        }
        if (m != 0) {
          break label2088;
        }
        k = 1;
        if (m != this.nS.size() - 1) {
          break label2085;
        }
        j = 1;
        if (localObject == null) {
          break label1250;
        }
        if ((((qgy.d)localObject).equals(locald)) && (((qgy.d)localObject).Jz() == locald.Jz()) && (((qgy.d)localObject).JA() == locald.JA())) {
          break label1057;
        }
        ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((qgy.d)localObject).d, locald.d });
        this.nS.set(m, locald);
        i = 1;
      }
      label1180:
      for (;;)
      {
        n += 1;
        m += 1;
        break;
        localObject = null;
        break label906;
        label1057:
        if (((qgy.d)localObject).nv.size() != locald.nv.size())
        {
          ram.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((qgy.d)localObject).d, ((qgy.d)localObject).nv, locald.nv);
          this.nS.set(m, locald);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((qgy.d)localObject).nv.size()) {
              break label2079;
            }
            if (!TextUtils.equals((CharSequence)((qgy.d)localObject).nv.get(i1), (CharSequence)locald.nv.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((qgy.d)localObject).d, ((qgy.d)localObject).nv, locald.nv });
                this.nS.set(m, locald);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1250:
          ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", locald.d);
          this.nS.add(m, locald);
          i = 1;
        }
      }
      label1282:
      ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
    }
    for (;;)
    {
      if ((i2 == -1) && (i3 != -1))
      {
        n = localArrayList.size() - 1;
        m = i3;
        if (n >= 0)
        {
          if (m >= 0)
          {
            localObject = (qgy.d)this.nS.get(m);
            label1342:
            locald = (qgy.d)localArrayList.get(n);
            if (locald == null) {
              break label1590;
            }
            if (m == 0) {
              k = 1;
            }
            if (m == this.nS.size() - 1) {
              j = 1;
            }
            if (localObject == null) {
              break label1559;
            }
            if ((((qgy.d)localObject).equals(locald)) && (((qgy.d)localObject).Jz() == locald.Jz()) && (((qgy.d)localObject).JA() == locald.JA())) {
              break label1493;
            }
            ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((qgy.d)localObject).d, locald.d });
            this.nS.set(m, locald);
            i = 1;
          }
          for (;;)
          {
            label1472:
            n -= 1;
            m -= 1;
            break;
            localObject = null;
            break label1342;
            label1493:
            if (((qgy.d)localObject).nv.size() == locald.nv.size()) {
              break label2070;
            }
            ram.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((qgy.d)localObject).d, ((qgy.d)localObject).nv, locald.nv);
            this.nS.set(m, locald);
            i = 1;
            continue;
            label1559:
            ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", locald.d);
            this.nS.add(0, locald);
            i = 1;
          }
          label1590:
          ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.nS.get(0)) != -1)
          {
            this.nS.clear();
            this.nS.addAll(parama.nP);
            i = 1;
            j = 1;
            k = 1;
            break label469;
          }
          ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          annt.e(new Throwable());
          return;
          if (this.jdField_a_of_type_Qjr != null)
          {
            i = n;
            if (this.jdField_a_of_type_Qjr.Jz()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Qjr = new qjr(new ErrorMessage(parama.g), true);
          localArrayList.add(0, this.jdField_a_of_type_Qjr);
          break label617;
          label1742:
          i = m;
          if (this.jdField_a_of_type_Qjr == null) {
            break label617;
          }
          this.jdField_a_of_type_Qjr = null;
          i = 1;
          break label617;
          label1762:
          i = m;
          if (this.jdField_a_of_type_Qjr == null) {
            break label617;
          }
          localArrayList.add(0, this.jdField_a_of_type_Qjr);
          i = m;
          break label617;
          label1788:
          if ((this.jdField_b_of_type_Qjr == null) || (!this.jdField_b_of_type_Qjr.Jz())) {
            i = 1;
          }
          this.jdField_b_of_type_Qjr = new qjr(new ErrorMessage(parama.h), false);
          localArrayList.add(this.jdField_b_of_type_Qjr);
          j = i;
          break label743;
          label1846:
          j = i;
          if (this.jdField_b_of_type_Qjr == null) {
            break label743;
          }
          this.jdField_b_of_type_Qjr = null;
          j = 1;
          break label743;
          label1867:
          j = i;
          if (this.jdField_b_of_type_Qjr == null) {
            break label743;
          }
          localArrayList.add(this.jdField_b_of_type_Qjr);
          j = i;
          break label743;
          label1893:
          ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((qgy.d)localArrayList.get(i)).d.groupId, paramc.groupId)) {}
          }
          for (;;)
          {
            ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramc.groupId);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.cl(localArrayList);
              ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() == i)
              {
                this.jdField_a_of_type_Qjk$a.onPageSelected(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
            return;
            i = -1;
          }
          label2049:
          break label696;
          label2052:
          i = 0;
          break label573;
        }
        m = i;
        i = k;
        k = m;
        break label469;
        label2070:
        break label1472;
      }
      label2079:
      i1 = 1;
      break label1180;
      label2085:
      break label950;
      label2088:
      break label931;
      label2091:
      continue;
      label2094:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  public void a(qgy.c paramc, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramc == null) || (paramString == null))
    {
      ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramc, paramString });
      return;
    }
    int i = 0;
    label42:
    if (i < this.nS.size()) {
      if (!((qgy.d)this.nS.get(i)).d.equals(paramc)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramc.groupId, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label42;
      }
      if (paramBoolean) {
        if (i < this.nS.size() - 1)
        {
          paramc = (qgy.d)this.nS.get(i + 1);
          label163:
          this.nS.remove(i);
          paramString = new ArrayList(this.nS);
          if (this.jdField_a_of_type_Qjr != null) {
            paramString.add(0, this.jdField_a_of_type_Qjr);
          }
          if (this.jdField_b_of_type_Qjr != null) {
            paramString.add(this.jdField_b_of_type_Qjr);
          }
          if (paramc != null) {
            break label818;
          }
          paramc = this.jdField_b_of_type_Qjr;
        }
      }
      label297:
      label818:
      for (;;)
      {
        if (paramc == null)
        {
          ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          n().finish();
          return;
          paramc = null;
          break label163;
        }
        ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramc.d.groupId });
        this.g = paramc.d;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.cl(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((qgy.d)paramString.get(i)).d.groupId, paramc.d.groupId)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() == i)
          {
            ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Qjk$a.onPageSelected(i);
            return;
            i += 1;
            break label297;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (qgy.d)this.nS.get(i);
          k = ((qgy.d)localObject).nv.indexOf(paramString);
          if (k < 0)
          {
            ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((qgy.d)localObject).nv });
            rom.assertTrue(false, "找不到被删除的vid");
            return;
          }
          if (k < ((qgy.d)localObject).nv.size() - 1)
          {
            paramString = (String)((qgy.d)localObject).nv.get(k + 1);
            paramc = (qgy.c)localObject;
          }
          for (;;)
          {
            ((qgy.d)localObject).nv.remove(k);
            localArrayList = new ArrayList(this.nS);
            if (this.jdField_a_of_type_Qjr != null) {
              localArrayList.add(0, this.jdField_a_of_type_Qjr);
            }
            if (this.jdField_b_of_type_Qjr != null) {
              localArrayList.add(this.jdField_b_of_type_Qjr);
            }
            localObject = paramc;
            if (paramc == null) {
              localObject = this.jdField_b_of_type_Qjr;
            }
            if (localObject == null)
            {
              ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              n().finish();
              return;
              if (i < this.nS.size() - 1)
              {
                paramc = (qgy.d)this.nS.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramc = "vid";
                ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramc, ((qgy.d)localObject).d.groupId, paramString });
                this.g = ((qgy.d)localObject).d;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.cl(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label695:
                if (i >= localArrayList.size()) {
                  break label798;
                }
                if (!TextUtils.equals(((qgy.d)localArrayList.get(i)).d.groupId, ((qgy.d)localObject).d.groupId)) {
                  break label778;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.getCurrentItem() == i)
                {
                  ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Qjk$a.onPageSelected(i);
                  return;
                  paramc = "group";
                  break;
                  i += 1;
                  break label695;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramc = null;
            paramString = localArrayList;
          }
          i = -1;
        }
      }
      label778:
      label798:
      i = -1;
    }
  }
  
  public void a(qiw paramqiw)
  {
    this.jdField_b_of_type_Qiw = paramqiw;
  }
  
  public boolean a(@Nullable qjw paramqjw)
  {
    if (this.jdField_a_of_type_Qjk$a.Nr) {
      ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label296:
    do
    {
      return false;
      if (paramqjw == null)
      {
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Qjw });
        if (this.jdField_a_of_type_Qjw != null) {
          this.jdField_a_of_type_Qjw.sE(false);
        }
        this.jdField_a_of_type_Qjw = null;
        return false;
      }
      if (this.jdField_a_of_type_Qjw != paramqjw)
      {
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Qjw, paramqjw });
        if (this.jdField_a_of_type_Qjw != null) {
          this.jdField_a_of_type_Qjw.sE(false);
        }
        this.jdField_a_of_type_Qjw = paramqjw;
        localObject = paramqjw.c;
        ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).d.groupId, paramqjw.a.vid);
        this.fT.put(((StoryPlayerGroupHolder)localObject).d.groupId, paramqjw.a.vid);
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject).bmz == ((StoryPlayerGroupHolder)localObject).nR.size() - 1)
        {
          bool1 = true;
          if (((StoryPlayerGroupHolder)localObject).bmz != 0) {
            break label296;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          boolean bool3 = bool1;
          if (bool1)
          {
            bool3 = bool1;
            if (((StoryPlayerGroupHolder)localObject).JI()) {
              bool3 = false;
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(bool3, bool2, true, true);
          localObject = (qnv)((StoryPlayerGroupHolder)localObject).b(qnv.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramqjw.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((qnv)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramqjw.sE(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramqjw.isSelected());
    ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramqjw });
    Object localObject = paramqjw.c;
    ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).d.groupId, paramqjw.a.vid);
    this.fT.put(((StoryPlayerGroupHolder)localObject).d.groupId, paramqjw.a.vid);
    localObject = (qnv)((StoryPlayerGroupHolder)localObject).b(qnv.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramqjw.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((qnv)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramqjw.sE(true);
    return true;
  }
  
  public List<qgy.d> be()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.be();
  }
  
  public void bog()
  {
    if ((this.jdField_a_of_type_Qjw != null) && (this.jdField_a_of_type_Qjw.isSelected())) {
      this.jdField_a_of_type_Qjw.sE(false);
    }
  }
  
  public void boy() {}
  
  public String fX(String paramString)
  {
    return (String)this.fT.get(paramString);
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_Qjc.a(this);
  }
  
  public class a
    implements XViewPager.f
  {
    boolean Nr = false;
    private String axy;
    int pT = -1;
    int scrollState = 0;
    
    private a() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      int i = qjk.this.a.getCurrentItem();
      Object localObject = qjk.this.a(i);
      if (localObject != null)
      {
        localObject = ((StoryPlayerGroupHolder)localObject).a();
        if ((localObject instanceof qjx))
        {
          localObject = (VideoViewVideoHolder)((qjx)localObject).b(VideoViewVideoHolder.class);
          if (localObject != null)
          {
            if (paramInt != 1) {
              break label94;
            }
            ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
            ((VideoViewVideoHolder)localObject).boH();
          }
        }
      }
      for (;;)
      {
        if (qjk.a(qjk.this) != null) {
          qjk.a(qjk.this).dT(i, paramInt);
        }
        return;
        label94:
        if (paramInt == 0)
        {
          ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(qjk.this.a.sG()));
          if (!((VideoViewVideoHolder)localObject).a.isPlaying()) {
            ((VideoViewVideoHolder)localObject).boG();
          }
          ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (qjk.a(qjk.this) != null) {
        qjk.a(qjk.this).b(qjk.this.a.getCurrentItem(), paramInt1, paramFloat, paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      qjk.a(qjk.this);
      Object localObject1 = qjk.a(qjk.this).be();
      if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
        qjk.a(qjk.this, ((qgy.d)((List)localObject1).get(paramInt)).d);
      }
      localObject1 = qjk.this.a(paramInt);
      boolean bool1;
      boolean bool2;
      if (localObject1 != null)
      {
        Object localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
        ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
        if (localObject2 != null)
        {
          if (((StoryPlayerGroupHolder)localObject1).bmz != ((StoryPlayerGroupHolder)localObject1).nR.size() - 1) {
            break label323;
          }
          bool1 = true;
          if (((StoryPlayerGroupHolder)localObject1).bmz != 0) {
            break label328;
          }
          bool2 = true;
          label128:
          boolean bool3 = bool1;
          if (bool1)
          {
            bool3 = bool1;
            if (((StoryPlayerGroupHolder)localObject1).JI()) {
              bool3 = false;
            }
          }
          qjk.this.a.setEnableScrollDirection(bool3, bool2, true, true);
          if (qjk.a(qjk.this) != null) {
            qjk.a(qjk.this).aa(paramInt, ((qjw)localObject2).bmB, ((qjw)localObject2).bmB);
          }
        }
        label197:
        if (!(qjk.a(qjk.this) instanceof qhc.a)) {
          break label357;
        }
        localObject1 = ((qhc.a)qjk.a(qjk.this)).g;
        if (localObject1 != null)
        {
          if (TextUtils.equals(((puh)localObject1).unionId, this.axy)) {
            break label343;
          }
          this.axy = ((puh)localObject1).unionId;
          localObject2 = new pve();
          ((pve)localObject2).nodeType = ((puh)localObject1).nodeType;
          ((pve)localObject2).unionId = ((puh)localObject1).unionId;
          ((pve)localObject2).recommendId = ((puh)localObject1).recommendId;
          ((puh)localObject1).redPoint = false;
          ppv.a().a((ppw)localObject2, null);
          ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
        }
      }
      for (;;)
      {
        wn(paramInt);
        return;
        label323:
        bool1 = false;
        break;
        label328:
        bool2 = false;
        break label128;
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
        break label197;
        label343:
        ram.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.axy);
        continue;
        label357:
        ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
      }
    }
    
    public void wn(int paramInt)
    {
      Iterator localIterator = qjk.a(qjk.this).fU.values().iterator();
      paramInt = 0;
      if (localIterator.hasNext())
      {
        StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)localIterator.next();
        if ((paramInt != 0) || (localStoryPlayerGroupHolder.JJ()))
        {
          paramInt = 1;
          label55:
          if (paramInt == 0) {
            break label77;
          }
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          qjk.this.b(null);
        }
        return;
        paramInt = 0;
        break label55;
        label77:
        break;
      }
    }
  }
  
  class b
    implements qiw
  {
    private b() {}
    
    public void aa(int paramInt1, int paramInt2, int paramInt3)
    {
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)qjk.a(qjk.this).fU.get(Integer.valueOf(paramInt1));
      if (localStoryPlayerGroupHolder == null) {
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, find vertical holder is null");
      }
      do
      {
        return;
        if (qjk.a(qjk.this) == null)
        {
          ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, mCurrentSelectedGroupId is null");
          return;
        }
        ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, verticalPosition=%d, oldHorizontalPosition=%d, horizontalPosition=%d, currentGroup=%s, onSelectedGroup=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), qjk.a(qjk.this), localStoryPlayerGroupHolder.d });
      } while ((qjk.a(qjk.this) != localStoryPlayerGroupHolder.d) && (!qjk.a(qjk.this).equals(localStoryPlayerGroupHolder.d)));
      boolean bool1;
      if (localStoryPlayerGroupHolder.a(paramInt3) != null)
      {
        if (qjk.a(qjk.this) != null) {
          qjk.a(qjk.this).aa(paramInt1, paramInt2, paramInt3);
        }
        if (localStoryPlayerGroupHolder.bmz != localStoryPlayerGroupHolder.nR.size() - 1) {
          break label257;
        }
        bool1 = true;
        label195:
        if (localStoryPlayerGroupHolder.bmz != 0) {
          break label263;
        }
      }
      label257:
      label263:
      for (boolean bool2 = true;; bool2 = false)
      {
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (localStoryPlayerGroupHolder.JI()) {
            bool3 = false;
          }
        }
        qjk.this.a.setEnableScrollDirection(bool3, bool2, true, true);
        return;
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, getPageHolderOfPosition return null. onSelected true failed");
        break;
        bool1 = false;
        break label195;
      }
    }
    
    public void b(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
    {
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = qjk.this.a(paramInt1);
      if (localStoryPlayerGroupHolder == null) {
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, find vertical holder is null");
      }
      do
      {
        return;
        if (qjk.a(qjk.this) == null)
        {
          ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, mCurrentSelectedGroupId is null");
          return;
        }
      } while (((qjk.a(qjk.this) != localStoryPlayerGroupHolder.d) && (!qjk.a(qjk.this).equals(localStoryPlayerGroupHolder.d))) || (qjk.a(qjk.this) == null));
      qjk.a(qjk.this).b(paramInt1, paramInt2, paramFloat, paramInt3);
    }
    
    public void dT(int paramInt1, int paramInt2)
    {
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = qjk.this.a(paramInt1);
      if (localStoryPlayerGroupHolder == null) {
        ram.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, find vertical holder is null");
      }
      do
      {
        return;
        if (qjk.a(qjk.this) == null)
        {
          ram.w("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, mCurrentSelectedGroupId is null");
          return;
        }
        ram.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, verticalPosition=%d, currentGroup=%s, onSelectedGroup=%s", Integer.valueOf(paramInt1), qjk.a(qjk.this), localStoryPlayerGroupHolder.d);
      } while ((qjk.a(qjk.this) != localStoryPlayerGroupHolder.d) && (!qjk.a(qjk.this).equals(localStoryPlayerGroupHolder.d)));
      Object localObject = localStoryPlayerGroupHolder.a();
      if ((localObject instanceof qjx))
      {
        localObject = (VideoViewVideoHolder)((qjx)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null)
        {
          if (paramInt2 != 1) {
            break label168;
          }
          ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, pause because of dragging");
          ((VideoViewVideoHolder)localObject).boH();
        }
      }
      label143:
      while (qjk.a(qjk.this) != null)
      {
        qjk.a(qjk.this).dT(paramInt1, paramInt2);
        return;
        label168:
        if (paramInt2 == 0)
        {
          if ((!localStoryPlayerGroupHolder.JI()) || (!localStoryPlayerGroupHolder.JH())) {
            break label229;
          }
          ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, no need start");
        }
      }
      for (;;)
      {
        rar.a("play_video", "slide_up_down", 0, 0, new String[] { "2", "", "", "" });
        break label143;
        break;
        label229:
        ram.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, start because of idle");
        ((VideoViewVideoHolder)localObject).boG();
      }
    }
  }
  
  class c
    implements VideoViewVideoHolder.j
  {
    private c() {}
    
    public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean) {}
    
    public void a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb) {}
    
    public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, int paramInt, Object paramObject)
    {
      return false;
    }
    
    public void b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb) {}
    
    public boolean b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, boolean paramBoolean)
    {
      return qjk.this.a.a(paramVideoViewVideoHolder, paramqlb, paramBoolean);
    }
    
    public void c(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjk
 * JD-Core Version:    0.7.0.1
 */