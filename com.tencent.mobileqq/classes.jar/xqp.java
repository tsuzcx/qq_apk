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

public class xqp
  extends xqo
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<xmt> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private xms jdField_a_of_type_Xms;
  private xpy jdField_a_of_type_Xpy;
  @NonNull
  final xqg jdField_a_of_type_Xqg;
  private final xqq jdField_a_of_type_Xqq;
  private final xqr jdField_a_of_type_Xqr;
  private xra jdField_a_of_type_Xra;
  private xrg jdField_a_of_type_Xrg;
  private final xsn jdField_a_of_type_Xsn;
  private xra b;
  
  public xqp(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131381041);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Xqg = new xqg();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new xpz(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new xqr(this, null);
    this.jdField_a_of_type_Xqr = ((xqr)localObject);
    xqs localxqs = new xqs(this, null);
    this.jdField_a_of_type_Xsn = localxqs;
    paramViewGroup.a((xpy)localObject, localxqs);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new xqq(this, null);
    this.jdField_a_of_type_Xqq = ((xqq)localObject);
    paramViewGroup.setOnPageChangeListener((xsx)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<xmt> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xmt localxmt = (xmt)localIterator.next();
      if (localxmt.c()) {
        localArrayList.add(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localxmt.b()) {
        localArrayList.add(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString + "(" + localxmt.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    xst localxst = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localxst != null) {
      return (StoryPlayerGroupHolder)localxst.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<xmt> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public xms a()
  {
    return this.jdField_a_of_type_Xms;
  }
  
  public void a(xmq paramxmq, xms paramxms)
  {
    yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramxmq.jdField_a_of_type_Boolean), Boolean.valueOf(paramxmq.jdField_b_of_type_Boolean), paramxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramxmq.jdField_a_of_type_JavaUtilList.size()), paramxms.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Xms = paramxms;
    ArrayList localArrayList = new ArrayList(paramxmq.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    xmt localxmt;
    while (((Iterator)localObject).hasNext())
    {
      localxmt = (xmt)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localxmt.jdField_a_of_type_JavaLangString))
        {
          yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, localxmt.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, localxmt.jdField_a_of_type_JavaLangString);
        }
        else if (localxmt.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, localxmt.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, localxmt.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localxmt.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Xqg.a(paramxmq, paramxms.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramxmq.jdField_a_of_type_JavaUtilList);
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
      yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (xmt)localArrayList.get(0) });
      if (paramxmq.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Xra != null) && (this.jdField_a_of_type_Xra.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Xra = new xra("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Xra);
        if (j == 0) {
          break label1848;
        }
        yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (xmt)localArrayList.get(localArrayList.size() - 1) });
        if (paramxmq.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new xra("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (xmt)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (xmt)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (xmt)this.jdField_a_of_type_JavaUtilList.get(m);
        localxmt = (xmt)localArrayList.get(n);
        if (localxmt == null) {
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
        if ((((xmt)localObject).equals(localxmt)) && (((xmt)localObject).b() == localxmt.b()) && (((xmt)localObject).c() == localxmt.c())) {
          break label1047;
        }
        yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((xmt)localObject).jdField_a_of_type_Xms, localxmt.jdField_a_of_type_Xms });
        this.jdField_a_of_type_JavaUtilList.set(m, localxmt);
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
        if (((xmt)localObject).jdField_a_of_type_JavaUtilList.size() != localxmt.jdField_a_of_type_JavaUtilList.size())
        {
          yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xmt)localObject).jdField_a_of_type_Xms, ((xmt)localObject).jdField_a_of_type_JavaUtilList, localxmt.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localxmt);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((xmt)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((xmt)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localxmt.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((xmt)localObject).jdField_a_of_type_Xms, ((xmt)localObject).jdField_a_of_type_JavaUtilList, localxmt.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localxmt);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localxmt.jdField_a_of_type_Xms);
          this.jdField_a_of_type_JavaUtilList.add(m, localxmt);
          i = 1;
        }
      }
      label1269:
      yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (xmt)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localxmt = (xmt)localArrayList.get(n);
            if (localxmt == null) {
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
            if ((((xmt)localObject).equals(localxmt)) && (((xmt)localObject).b() == localxmt.b()) && (((xmt)localObject).c() == localxmt.c())) {
              break label1478;
            }
            yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((xmt)localObject).jdField_a_of_type_Xms, localxmt.jdField_a_of_type_Xms });
            this.jdField_a_of_type_JavaUtilList.set(m, localxmt);
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
            if (((xmt)localObject).jdField_a_of_type_JavaUtilList.size() == localxmt.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xmt)localObject).jdField_a_of_type_Xms, ((xmt)localObject).jdField_a_of_type_JavaUtilList, localxmt.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localxmt);
            i = 1;
            continue;
            label1543:
            yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localxmt.jdField_a_of_type_Xms);
            this.jdField_a_of_type_JavaUtilList.add(0, localxmt);
            i = 1;
          }
          label1573:
          yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramxmq.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          bdkh.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Xra != null)
          {
            i = n;
            if (this.jdField_a_of_type_Xra.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Xra = new xra(new ErrorMessage(paramxmq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Xra);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Xra == null) {
            break label611;
          }
          this.jdField_a_of_type_Xra = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Xra == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Xra);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new xra(new ErrorMessage(paramxmq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((xmt)localArrayList.get(i)).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxms.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramxms.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Xqq.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(xms paramxms, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramxms == null) || (paramString == null))
    {
      yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramxms, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((xmt)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Xms.equals(paramxms)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramxms.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramxms = (xmt)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Xra != null) {
            paramString.add(0, this.jdField_a_of_type_Xra);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramxms != null) {
            break label809;
          }
          paramxms = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramxms == null)
        {
          yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramxms = null;
          break label161;
        }
        yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramxms.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Xms = paramxms.jdField_a_of_type_Xms;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((xmt)paramString.get(i)).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxms.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Xqq.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (xmt)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((xmt)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((xmt)localObject).jdField_a_of_type_JavaUtilList });
            znw.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((xmt)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((xmt)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramxms = (xms)localObject;
          }
          for (;;)
          {
            ((xmt)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Xra != null) {
              localArrayList.add(0, this.jdField_a_of_type_Xra);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramxms;
            if (paramxms == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramxms = (xmt)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramxms = "vid";
                yuk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramxms, ((xmt)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Xms = ((xmt)localObject).jdField_a_of_type_Xms;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((xmt)localArrayList.get(i)).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, ((xmt)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Xqq.a(i);
                  return;
                  paramxms = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramxms = null;
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
  
  public void a(xpy paramxpy)
  {
    this.jdField_a_of_type_Xpy = paramxpy;
  }
  
  public boolean a(@Nullable xrg paramxrg)
  {
    if (this.jdField_a_of_type_Xqq.jdField_a_of_type_Boolean) {
      yuk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramxrg == null)
      {
        yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Xrg });
        if (this.jdField_a_of_type_Xrg != null) {
          this.jdField_a_of_type_Xrg.a(false);
        }
        this.jdField_a_of_type_Xrg = null;
        return false;
      }
      if (this.jdField_a_of_type_Xrg != paramxrg)
      {
        yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Xrg, paramxrg });
        if (this.jdField_a_of_type_Xrg != null) {
          this.jdField_a_of_type_Xrg.a(false);
        }
        this.jdField_a_of_type_Xrg = paramxrg;
        localObject = paramxrg.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
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
          localObject = (xzd)((StoryPlayerGroupHolder)localObject).b(xzd.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramxrg.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((xzd)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramxrg.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramxrg.c());
    yuk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramxrg });
    Object localObject = paramxrg.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    yuk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, paramxrg.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
    localObject = (xzd)((StoryPlayerGroupHolder)localObject).b(xzd.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramxrg.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((xzd)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramxrg.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Xrg != null) && (this.jdField_a_of_type_Xrg.c())) {
      this.jdField_a_of_type_Xrg.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xqg.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Xrg != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Xrg.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    yup.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Xqg.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqp
 * JD-Core Version:    0.7.0.1
 */