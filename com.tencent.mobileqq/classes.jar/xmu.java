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

public class xmu
  extends xmt
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<xiy> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private xix jdField_a_of_type_Xix;
  private xmd jdField_a_of_type_Xmd;
  @NonNull
  final xml jdField_a_of_type_Xml;
  private final xmv jdField_a_of_type_Xmv;
  private final xmw jdField_a_of_type_Xmw;
  private xnf jdField_a_of_type_Xnf;
  private xnl jdField_a_of_type_Xnl;
  private final xos jdField_a_of_type_Xos;
  private xnf b;
  
  public xmu(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131380863);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Xml = new xml();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new xme(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new xmw(this, null);
    this.jdField_a_of_type_Xmw = ((xmw)localObject);
    xmx localxmx = new xmx(this, null);
    this.jdField_a_of_type_Xos = localxmx;
    paramViewGroup.a((xmd)localObject, localxmx);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new xmv(this, null);
    this.jdField_a_of_type_Xmv = ((xmv)localObject);
    paramViewGroup.setOnPageChangeListener((xpc)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<xiy> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xiy localxiy = (xiy)localIterator.next();
      if (localxiy.c()) {
        localArrayList.add(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localxiy.b()) {
        localArrayList.add(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString + "(" + localxiy.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    xoy localxoy = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localxoy != null) {
      return (StoryPlayerGroupHolder)localxoy.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<xiy> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public xix a()
  {
    return this.jdField_a_of_type_Xix;
  }
  
  public void a(xiv paramxiv, xix paramxix)
  {
    yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramxiv.jdField_a_of_type_Boolean), Boolean.valueOf(paramxiv.jdField_b_of_type_Boolean), paramxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramxiv.jdField_a_of_type_JavaUtilList.size()), paramxix.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Xix = paramxix;
    ArrayList localArrayList = new ArrayList(paramxiv.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    xiy localxiy;
    while (((Iterator)localObject).hasNext())
    {
      localxiy = (xiy)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localxiy.jdField_a_of_type_JavaLangString))
        {
          yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, localxiy.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, localxiy.jdField_a_of_type_JavaLangString);
        }
        else if (localxiy.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, localxiy.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, localxiy.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localxiy.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Xml.a(paramxiv, paramxix.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramxiv.jdField_a_of_type_JavaUtilList);
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
      yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (xiy)localArrayList.get(0) });
      if (paramxiv.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Xnf != null) && (this.jdField_a_of_type_Xnf.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Xnf = new xnf("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Xnf);
        if (j == 0) {
          break label1848;
        }
        yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (xiy)localArrayList.get(localArrayList.size() - 1) });
        if (paramxiv.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new xnf("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (xiy)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (xiy)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (xiy)this.jdField_a_of_type_JavaUtilList.get(m);
        localxiy = (xiy)localArrayList.get(n);
        if (localxiy == null) {
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
        if ((((xiy)localObject).equals(localxiy)) && (((xiy)localObject).b() == localxiy.b()) && (((xiy)localObject).c() == localxiy.c())) {
          break label1047;
        }
        yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((xiy)localObject).jdField_a_of_type_Xix, localxiy.jdField_a_of_type_Xix });
        this.jdField_a_of_type_JavaUtilList.set(m, localxiy);
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
        if (((xiy)localObject).jdField_a_of_type_JavaUtilList.size() != localxiy.jdField_a_of_type_JavaUtilList.size())
        {
          yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xiy)localObject).jdField_a_of_type_Xix, ((xiy)localObject).jdField_a_of_type_JavaUtilList, localxiy.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localxiy);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((xiy)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((xiy)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localxiy.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((xiy)localObject).jdField_a_of_type_Xix, ((xiy)localObject).jdField_a_of_type_JavaUtilList, localxiy.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localxiy);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localxiy.jdField_a_of_type_Xix);
          this.jdField_a_of_type_JavaUtilList.add(m, localxiy);
          i = 1;
        }
      }
      label1269:
      yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (xiy)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localxiy = (xiy)localArrayList.get(n);
            if (localxiy == null) {
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
            if ((((xiy)localObject).equals(localxiy)) && (((xiy)localObject).b() == localxiy.b()) && (((xiy)localObject).c() == localxiy.c())) {
              break label1478;
            }
            yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((xiy)localObject).jdField_a_of_type_Xix, localxiy.jdField_a_of_type_Xix });
            this.jdField_a_of_type_JavaUtilList.set(m, localxiy);
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
            if (((xiy)localObject).jdField_a_of_type_JavaUtilList.size() == localxiy.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xiy)localObject).jdField_a_of_type_Xix, ((xiy)localObject).jdField_a_of_type_JavaUtilList, localxiy.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localxiy);
            i = 1;
            continue;
            label1543:
            yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localxiy.jdField_a_of_type_Xix);
            this.jdField_a_of_type_JavaUtilList.add(0, localxiy);
            i = 1;
          }
          label1573:
          yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramxiv.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          bcrp.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Xnf != null)
          {
            i = n;
            if (this.jdField_a_of_type_Xnf.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Xnf = new xnf(new ErrorMessage(paramxiv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Xnf);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Xnf == null) {
            break label611;
          }
          this.jdField_a_of_type_Xnf = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Xnf == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Xnf);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new xnf(new ErrorMessage(paramxiv.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((xiy)localArrayList.get(i)).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxix.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramxix.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Xmv.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(xix paramxix, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramxix == null) || (paramString == null))
    {
      yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramxix, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((xiy)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Xix.equals(paramxix)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramxix.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramxix = (xiy)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Xnf != null) {
            paramString.add(0, this.jdField_a_of_type_Xnf);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramxix != null) {
            break label809;
          }
          paramxix = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramxix == null)
        {
          yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramxix = null;
          break label161;
        }
        yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramxix.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Xix = paramxix.jdField_a_of_type_Xix;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((xiy)paramString.get(i)).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxix.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Xmv.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (xiy)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((xiy)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((xiy)localObject).jdField_a_of_type_JavaUtilList });
            zkb.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((xiy)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((xiy)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramxix = (xix)localObject;
          }
          for (;;)
          {
            ((xiy)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Xnf != null) {
              localArrayList.add(0, this.jdField_a_of_type_Xnf);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramxix;
            if (paramxix == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramxix = (xiy)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramxix = "vid";
                yqp.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramxix, ((xiy)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Xix = ((xiy)localObject).jdField_a_of_type_Xix;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((xiy)localArrayList.get(i)).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, ((xiy)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Xmv.a(i);
                  return;
                  paramxix = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramxix = null;
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
  
  public void a(xmd paramxmd)
  {
    this.jdField_a_of_type_Xmd = paramxmd;
  }
  
  public boolean a(@Nullable xnl paramxnl)
  {
    if (this.jdField_a_of_type_Xmv.jdField_a_of_type_Boolean) {
      yqp.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramxnl == null)
      {
        yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Xnl });
        if (this.jdField_a_of_type_Xnl != null) {
          this.jdField_a_of_type_Xnl.a(false);
        }
        this.jdField_a_of_type_Xnl = null;
        return false;
      }
      if (this.jdField_a_of_type_Xnl != paramxnl)
      {
        yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Xnl, paramxnl });
        if (this.jdField_a_of_type_Xnl != null) {
          this.jdField_a_of_type_Xnl.a(false);
        }
        this.jdField_a_of_type_Xnl = paramxnl;
        localObject = paramxnl.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString);
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
          localObject = (xvi)((StoryPlayerGroupHolder)localObject).b(xvi.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramxnl.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((xvi)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramxnl.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramxnl.c());
    yqp.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramxnl });
    Object localObject = paramxnl.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    yqp.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, paramxnl.jdField_a_of_type_Xne.jdField_a_of_type_JavaLangString);
    localObject = (xvi)((StoryPlayerGroupHolder)localObject).b(xvi.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramxnl.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((xvi)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramxnl.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Xnl != null) && (this.jdField_a_of_type_Xnl.c())) {
      this.jdField_a_of_type_Xnl.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xml.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Xnl != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Xnl.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    yqu.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Xml.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmu
 * JD-Core Version:    0.7.0.1
 */