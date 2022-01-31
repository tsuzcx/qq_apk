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

public class ual
  extends uak
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<twp> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private two jdField_a_of_type_Two;
  private tzu jdField_a_of_type_Tzu;
  @NonNull
  final uac jdField_a_of_type_Uac;
  private final uam jdField_a_of_type_Uam;
  private final uan jdField_a_of_type_Uan;
  private uaw jdField_a_of_type_Uaw;
  private ubc jdField_a_of_type_Ubc;
  private final ucj jdField_a_of_type_Ucj;
  private uaw b;
  
  public ual(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131379147);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Uac = new uac();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new tzv(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new uan(this, null);
    this.jdField_a_of_type_Uan = ((uan)localObject);
    uao localuao = new uao(this, null);
    this.jdField_a_of_type_Ucj = localuao;
    paramViewGroup.a((tzu)localObject, localuao);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new uam(this, null);
    this.jdField_a_of_type_Uam = ((uam)localObject);
    paramViewGroup.setOnPageChangeListener((uct)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<twp> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      twp localtwp = (twp)localIterator.next();
      if (localtwp.c()) {
        localArrayList.add(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localtwp.b()) {
        localArrayList.add(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString + "(" + localtwp.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    ucp localucp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localucp != null) {
      return (StoryPlayerGroupHolder)localucp.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<twp> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public two a()
  {
    return this.jdField_a_of_type_Two;
  }
  
  public void a(twm paramtwm, two paramtwo)
  {
    veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramtwm.jdField_a_of_type_Boolean), Boolean.valueOf(paramtwm.jdField_b_of_type_Boolean), paramtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramtwm.jdField_a_of_type_JavaUtilList.size()), paramtwo.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Two = paramtwo;
    ArrayList localArrayList = new ArrayList(paramtwm.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    twp localtwp;
    while (((Iterator)localObject).hasNext())
    {
      localtwp = (twp)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localtwp.jdField_a_of_type_JavaLangString))
        {
          veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, localtwp.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, localtwp.jdField_a_of_type_JavaLangString);
        }
        else if (localtwp.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, localtwp.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, localtwp.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localtwp.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Uac.a(paramtwm, paramtwo.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramtwm.jdField_a_of_type_JavaUtilList);
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
      veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (twp)localArrayList.get(0) });
      if (paramtwm.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Uaw != null) && (this.jdField_a_of_type_Uaw.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Uaw = new uaw("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Uaw);
        if (j == 0) {
          break label1848;
        }
        veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (twp)localArrayList.get(localArrayList.size() - 1) });
        if (paramtwm.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new uaw("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (twp)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (twp)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (twp)this.jdField_a_of_type_JavaUtilList.get(m);
        localtwp = (twp)localArrayList.get(n);
        if (localtwp == null) {
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
        if ((((twp)localObject).equals(localtwp)) && (((twp)localObject).b() == localtwp.b()) && (((twp)localObject).c() == localtwp.c())) {
          break label1047;
        }
        veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((twp)localObject).jdField_a_of_type_Two, localtwp.jdField_a_of_type_Two });
        this.jdField_a_of_type_JavaUtilList.set(m, localtwp);
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
        if (((twp)localObject).jdField_a_of_type_JavaUtilList.size() != localtwp.jdField_a_of_type_JavaUtilList.size())
        {
          veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((twp)localObject).jdField_a_of_type_Two, ((twp)localObject).jdField_a_of_type_JavaUtilList, localtwp.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localtwp);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((twp)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((twp)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localtwp.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((twp)localObject).jdField_a_of_type_Two, ((twp)localObject).jdField_a_of_type_JavaUtilList, localtwp.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localtwp);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localtwp.jdField_a_of_type_Two);
          this.jdField_a_of_type_JavaUtilList.add(m, localtwp);
          i = 1;
        }
      }
      label1269:
      veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (twp)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localtwp = (twp)localArrayList.get(n);
            if (localtwp == null) {
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
            if ((((twp)localObject).equals(localtwp)) && (((twp)localObject).b() == localtwp.b()) && (((twp)localObject).c() == localtwp.c())) {
              break label1478;
            }
            veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((twp)localObject).jdField_a_of_type_Two, localtwp.jdField_a_of_type_Two });
            this.jdField_a_of_type_JavaUtilList.set(m, localtwp);
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
            if (((twp)localObject).jdField_a_of_type_JavaUtilList.size() == localtwp.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((twp)localObject).jdField_a_of_type_Two, ((twp)localObject).jdField_a_of_type_JavaUtilList, localtwp.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localtwp);
            i = 1;
            continue;
            label1543:
            veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localtwp.jdField_a_of_type_Two);
            this.jdField_a_of_type_JavaUtilList.add(0, localtwp);
            i = 1;
          }
          label1573:
          veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramtwm.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          axps.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Uaw != null)
          {
            i = n;
            if (this.jdField_a_of_type_Uaw.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Uaw = new uaw(new ErrorMessage(paramtwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Uaw);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Uaw == null) {
            break label611;
          }
          this.jdField_a_of_type_Uaw = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Uaw == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Uaw);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new uaw(new ErrorMessage(paramtwm.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((twp)localArrayList.get(i)).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramtwo.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramtwo.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Uam.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(two paramtwo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramtwo == null) || (paramString == null))
    {
      veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramtwo, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((twp)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Two.equals(paramtwo)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramtwo.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramtwo = (twp)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Uaw != null) {
            paramString.add(0, this.jdField_a_of_type_Uaw);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramtwo != null) {
            break label809;
          }
          paramtwo = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramtwo == null)
        {
          veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramtwo = null;
          break label161;
        }
        veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramtwo.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Two = paramtwo.jdField_a_of_type_Two;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((twp)paramString.get(i)).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramtwo.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Uam.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (twp)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((twp)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((twp)localObject).jdField_a_of_type_JavaUtilList });
            vxs.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((twp)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((twp)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramtwo = (two)localObject;
          }
          for (;;)
          {
            ((twp)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Uaw != null) {
              localArrayList.add(0, this.jdField_a_of_type_Uaw);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramtwo;
            if (paramtwo == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramtwo = (twp)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramtwo = "vid";
                veg.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramtwo, ((twp)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Two = ((twp)localObject).jdField_a_of_type_Two;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((twp)localArrayList.get(i)).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, ((twp)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Uam.a(i);
                  return;
                  paramtwo = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramtwo = null;
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
  
  public void a(tzu paramtzu)
  {
    this.jdField_a_of_type_Tzu = paramtzu;
  }
  
  public boolean a(@Nullable ubc paramubc)
  {
    if (this.jdField_a_of_type_Uam.jdField_a_of_type_Boolean) {
      veg.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramubc == null)
      {
        veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Ubc });
        if (this.jdField_a_of_type_Ubc != null) {
          this.jdField_a_of_type_Ubc.a(false);
        }
        this.jdField_a_of_type_Ubc = null;
        return false;
      }
      if (this.jdField_a_of_type_Ubc != paramubc)
      {
        veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Ubc, paramubc });
        if (this.jdField_a_of_type_Ubc != null) {
          this.jdField_a_of_type_Ubc.a(false);
        }
        this.jdField_a_of_type_Ubc = paramubc;
        localObject = paramubc.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
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
          localObject = (uiz)((StoryPlayerGroupHolder)localObject).b(uiz.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramubc.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((uiz)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramubc.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramubc.c());
    veg.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramubc });
    Object localObject = paramubc.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    veg.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, paramubc.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
    localObject = (uiz)((StoryPlayerGroupHolder)localObject).b(uiz.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramubc.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((uiz)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramubc.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ubc != null) && (this.jdField_a_of_type_Ubc.c())) {
      this.jdField_a_of_type_Ubc.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Uac.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Ubc != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Ubc.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    vel.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Uac.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ual
 * JD-Core Version:    0.7.0.1
 */