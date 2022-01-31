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
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class vpa
  extends voz
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<vle> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vld jdField_a_of_type_Vld;
  private voj jdField_a_of_type_Voj;
  @NonNull
  final vor jdField_a_of_type_Vor;
  private final vpb jdField_a_of_type_Vpb;
  private final vpc jdField_a_of_type_Vpc;
  private vpl jdField_a_of_type_Vpl;
  private vpr jdField_a_of_type_Vpr;
  private final vqy jdField_a_of_type_Vqy;
  private vpl b;
  
  public vpa(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131379848);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Vor = new vor();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new vok(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new vpc(this, null);
    this.jdField_a_of_type_Vpc = ((vpc)localObject);
    vpd localvpd = new vpd(this, null);
    this.jdField_a_of_type_Vqy = localvpd;
    paramViewGroup.a((voj)localObject, localvpd);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new vpb(this, null);
    this.jdField_a_of_type_Vpb = ((vpb)localObject);
    paramViewGroup.setOnPageChangeListener((vri)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<vle> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vle localvle = (vle)localIterator.next();
      if (localvle.c()) {
        localArrayList.add(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localvle.b()) {
        localArrayList.add(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString + "(" + localvle.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    vre localvre = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localvre != null) {
      return (StoryPlayerGroupHolder)localvre.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<vle> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public vld a()
  {
    return this.jdField_a_of_type_Vld;
  }
  
  public void a(vlb paramvlb, vld paramvld)
  {
    wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramvlb.jdField_a_of_type_Boolean), Boolean.valueOf(paramvlb.jdField_b_of_type_Boolean), paramvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramvlb.jdField_a_of_type_JavaUtilList.size()), paramvld.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Vld = paramvld;
    ArrayList localArrayList = new ArrayList(paramvlb.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    vle localvle;
    while (((Iterator)localObject).hasNext())
    {
      localvle = (vle)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localvle.jdField_a_of_type_JavaLangString))
        {
          wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, localvle.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, localvle.jdField_a_of_type_JavaLangString);
        }
        else if (localvle.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, localvle.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, localvle.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localvle.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Vor.a(paramvlb, paramvld.jdField_a_of_type_JavaLangString);
    int i;
    int j;
    int k;
    label464:
    int n;
    int m;
    label567:
    label611:
    int i2;
    label689:
    label736:
    int i3;
    label897:
    label922:
    label941:
    int i1;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramvlb.jdField_a_of_type_JavaUtilList);
      i = 1;
      j = 1;
      k = 1;
      a("onBind, currentGroupInfoList", this.jdField_a_of_type_JavaUtilList);
      localArrayList.clear();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      n = 0;
      m = 0;
      if (i == 0) {
        break label1743;
      }
      wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (vle)localArrayList.get(0) });
      if (paramvlb.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Vpl != null) && (this.jdField_a_of_type_Vpl.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Vpl = new vpl("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Vpl);
        if (j == 0) {
          break label1848;
        }
        wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (vle)localArrayList.get(localArrayList.size() - 1) });
        if (paramvlb.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new vpl("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (vle)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (vle)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
      if (i2 == -1) {
        break label2071;
      }
      m = i2;
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      if (n >= localArrayList.size()) {
        break label2068;
      }
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (vle)this.jdField_a_of_type_JavaUtilList.get(m);
        localvle = (vle)localArrayList.get(n);
        if (localvle == null) {
          break label1269;
        }
        if (m != 0) {
          break label2065;
        }
        k = 1;
        if (m != this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label2062;
        }
        j = 1;
        if (localObject == null) {
          break label1238;
        }
        if ((((vle)localObject).equals(localvle)) && (((vle)localObject).b() == localvle.b()) && (((vle)localObject).c() == localvle.c())) {
          break label1047;
        }
        wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((vle)localObject).jdField_a_of_type_Vld, localvle.jdField_a_of_type_Vld });
        this.jdField_a_of_type_JavaUtilList.set(m, localvle);
        i = 1;
      }
      label1169:
      for (;;)
      {
        n += 1;
        m += 1;
        break;
        localObject = null;
        break label897;
        label1047:
        if (((vle)localObject).jdField_a_of_type_JavaUtilList.size() != localvle.jdField_a_of_type_JavaUtilList.size())
        {
          wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((vle)localObject).jdField_a_of_type_Vld, ((vle)localObject).jdField_a_of_type_JavaUtilList, localvle.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localvle);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((vle)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((vle)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localvle.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((vle)localObject).jdField_a_of_type_Vld, ((vle)localObject).jdField_a_of_type_JavaUtilList, localvle.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localvle);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localvle.jdField_a_of_type_Vld);
          this.jdField_a_of_type_JavaUtilList.add(m, localvle);
          i = 1;
        }
      }
      label1269:
      wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (vle)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localvle = (vle)localArrayList.get(n);
            if (localvle == null) {
              break label1573;
            }
            if (m == 0) {
              k = 1;
            }
            if (m == this.jdField_a_of_type_JavaUtilList.size() - 1) {
              j = 1;
            }
            if (localObject == null) {
              break label1543;
            }
            if ((((vle)localObject).equals(localvle)) && (((vle)localObject).b() == localvle.b()) && (((vle)localObject).c() == localvle.c())) {
              break label1478;
            }
            wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((vle)localObject).jdField_a_of_type_Vld, localvle.jdField_a_of_type_Vld });
            this.jdField_a_of_type_JavaUtilList.set(m, localvle);
            i = 1;
          }
          for (;;)
          {
            label1457:
            n -= 1;
            m -= 1;
            break;
            localObject = null;
            break label1328;
            label1478:
            if (((vle)localObject).jdField_a_of_type_JavaUtilList.size() == localvle.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((vle)localObject).jdField_a_of_type_Vld, ((vle)localObject).jdField_a_of_type_JavaUtilList, localvle.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localvle);
            i = 1;
            continue;
            label1543:
            wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localvle.jdField_a_of_type_Vld);
            this.jdField_a_of_type_JavaUtilList.add(0, localvle);
            i = 1;
          }
          label1573:
          wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramvlb.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          azlf.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Vpl != null)
          {
            i = n;
            if (this.jdField_a_of_type_Vpl.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Vpl = new vpl(new ErrorMessage(paramvlb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Vpl);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Vpl == null) {
            break label611;
          }
          this.jdField_a_of_type_Vpl = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Vpl == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Vpl);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new vpl(new ErrorMessage(paramvlb.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1827:
          j = i;
          if (this.b == null) {
            break label736;
          }
          this.b = null;
          j = 1;
          break label736;
          label1848:
          j = i;
          if (this.b == null) {
            break label736;
          }
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1874:
          wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((vle)localArrayList.get(i)).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvld.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramvld.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Vpb.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
            return;
            i = -1;
          }
          label2026:
          break label689;
          label2029:
          i = 0;
          break label567;
        }
        m = i;
        i = k;
        k = m;
        break label464;
        label2047:
        break label1457;
      }
      label2056:
      i1 = 1;
      break label1169;
      label2062:
      break label941;
      label2065:
      break label922;
      label2068:
      continue;
      label2071:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  public void a(vld paramvld, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramvld == null) || (paramString == null))
    {
      wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramvld, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((vle)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Vld.equals(paramvld)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramvld.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramvld = (vle)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Vpl != null) {
            paramString.add(0, this.jdField_a_of_type_Vpl);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramvld != null) {
            break label809;
          }
          paramvld = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramvld == null)
        {
          wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramvld = null;
          break label161;
        }
        wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramvld.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Vld = paramvld.jdField_a_of_type_Vld;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((vle)paramString.get(i)).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvld.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Vpb.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (vle)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((vle)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((vle)localObject).jdField_a_of_type_JavaUtilList });
            xmh.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((vle)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((vle)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramvld = (vld)localObject;
          }
          for (;;)
          {
            ((vle)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Vpl != null) {
              localArrayList.add(0, this.jdField_a_of_type_Vpl);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramvld;
            if (paramvld == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramvld = (vle)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramvld = "vid";
                wsv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramvld, ((vle)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Vld = ((vle)localObject).jdField_a_of_type_Vld;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((vle)localArrayList.get(i)).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, ((vle)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Vpb.a(i);
                  return;
                  paramvld = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramvld = null;
            paramString = localArrayList;
          }
          i = -1;
        }
      }
      label769:
      label789:
      i = -1;
    }
  }
  
  public void a(voj paramvoj)
  {
    this.jdField_a_of_type_Voj = paramvoj;
  }
  
  public boolean a(@Nullable vpr paramvpr)
  {
    if (this.jdField_a_of_type_Vpb.jdField_a_of_type_Boolean) {
      wsv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramvpr == null)
      {
        wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Vpr });
        if (this.jdField_a_of_type_Vpr != null) {
          this.jdField_a_of_type_Vpr.a(false);
        }
        this.jdField_a_of_type_Vpr = null;
        return false;
      }
      if (this.jdField_a_of_type_Vpr != paramvpr)
      {
        wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Vpr, paramvpr });
        if (this.jdField_a_of_type_Vpr != null) {
          this.jdField_a_of_type_Vpr.a(false);
        }
        this.jdField_a_of_type_Vpr = paramvpr;
        localObject = paramvpr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString);
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
        {
          bool1 = true;
          if (((StoryPlayerGroupHolder)localObject).b != 0) {
            break label292;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          boolean bool3 = bool1;
          if (bool1)
          {
            bool3 = bool1;
            if (((StoryPlayerGroupHolder)localObject).d()) {
              bool3 = false;
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(bool3, bool2, true, true);
          localObject = (vxo)((StoryPlayerGroupHolder)localObject).b(vxo.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramvpr.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((vxo)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramvpr.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramvpr.c());
    wsv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramvpr });
    Object localObject = paramvpr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    wsv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, paramvpr.jdField_a_of_type_Vpk.jdField_a_of_type_JavaLangString);
    localObject = (vxo)((StoryPlayerGroupHolder)localObject).b(vxo.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramvpr.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((vxo)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramvpr.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vpr != null) && (this.jdField_a_of_type_Vpr.c())) {
      this.jdField_a_of_type_Vpr.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Vor.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Vpr != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Vpr.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    wta.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Vor.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpa
 * JD-Core Version:    0.7.0.1
 */