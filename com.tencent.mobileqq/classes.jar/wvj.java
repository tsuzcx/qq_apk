import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.3;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wvj
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String i = alpo.a(2131704293);
  public static final String j = alpo.a(2131704107);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private uqr<usi> jdField_a_of_type_Uqr = new wvk(this);
  private xev jdField_a_of_type_Xev;
  private SparseArray<xej> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "", jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, f, g, h, j };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
  }
  
  public wvj(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private xej a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int k = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    xej localxej = (xej)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (k >= 0)
    {
      paramString = (xej)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(k);
      return paramString;
    }
    Object localObject = (xak)urr.a(8);
    localObject = localxej;
    switch (paramInt1)
    {
    default: 
      localObject = localxej;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new xet(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localxej;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new xet(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localxej;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new xet(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localxej;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new xet(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localxej;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((urk)urr.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
              {
                wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new xet(paramString, paramInt2, 2130845999, 2);
                continue;
                localObject = localxej;
                if (this.jdField_a_of_type_Xel != null)
                {
                  localObject = new xel(this.jdField_a_of_type_Xel.jdField_a_of_type_Int, paramString, paramInt2, this.jdField_a_of_type_Xel.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Xel.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Xel.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Xel.f, this.jdField_a_of_type_Xel.g, this.jdField_a_of_type_Xel.h, this.jdField_a_of_type_Xel.i, this.jdField_a_of_type_Xel.jdField_c_of_type_Int, this.jdField_a_of_type_Xel.jdField_d_of_type_Int, this.jdField_a_of_type_Xel.jdField_e_of_type_Int);
                  continue;
                  if (!(paramEditSource instanceof EditRecordVideoSource))
                  {
                    localObject = localxej;
                    if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                  }
                  else if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!axpq.a))
                  {
                    wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Wwe.a.h()))
                  {
                    wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe revert black model ! disable revert");
                    localObject = null;
                  }
                  else
                  {
                    localObject = new xet(paramString, paramInt2, 2130845998, 1);
                    continue;
                    if (!(paramEditSource instanceof EditRecordVideoSource))
                    {
                      localObject = localxej;
                      if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                    }
                    else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                    {
                      localObject = localxej;
                      if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                    }
                    else
                    {
                      localObject = localxej;
                      if (!"X9000".equalsIgnoreCase(Build.MODEL))
                      {
                        bool = ((Boolean)((urk)urr.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
                        {
                          wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Wwe.a.i()))
                        {
                          wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe slow black model ! disable slow");
                          localObject = null;
                        }
                        else
                        {
                          localObject = new xet(paramString, paramInt2, 2130846000, 3);
                          continue;
                          localObject = new xeq(0, paramString, paramInt2);
                          continue;
                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                          {
                            localObject = localxej;
                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                          }
                          else
                          {
                            if ((this.jdField_a_of_type_Xel != null) && (b())) {
                              break label926;
                            }
                            if (this.jdField_a_of_type_Xel == null) {
                              wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                            }
                            localObject = localxej;
                            if (!b())
                            {
                              wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                              localObject = localxej;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label926:
    paramEditSource = (usf)((uqs)urr.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Xev = new xev(0, paramString, paramInt2, ((usi)localObject).jdField_a_of_type_Int);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Xev;
      break;
      wsv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Xev = new xev(0, paramString, paramInt2, 0);
      paramEditSource.a();
    }
  }
  
  private xej a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    case 8: 
    default: 
      return null;
    case 10: 
      paramEditSource = ((usp)urr.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new xen(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, usp.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    wsv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    vbf localvbf = new vbf(1, paramInt2, paramInt1);
    ung.a().a(localvbf, new wvl(this));
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_Wxp.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((usf)((uqs)urr.a(20)).a(0)).a(this.jdField_a_of_type_Uqr);
  }
  
  public void a(int paramInt, uqm paramuqm)
  {
    wsv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), paramuqm, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_Wxp.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new EditVideoFilterNeo.3(this, paramuqm));
      }
    }
    else
    {
      return;
    }
    wsv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  public void d()
  {
    ((usf)((uqs)urr.a(20)).a(0)).b(this.jdField_a_of_type_Uqr);
    super.d();
  }
  
  public void f()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_Wwe.a;
    int m;
    label48:
    LocalMediaInfo localLocalMediaInfo;
    if (localEditVideoParams.a() == 1)
    {
      k = 1;
      if ((k == 0) || ((!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))) {
        break label127;
      }
      m = 1;
      if ((k == 0) || (m == 0)) {
        break label158;
      }
      localLocalMediaInfo = null;
      if (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        break label132;
      }
      localLocalMediaInfo = ((EditLocalPhotoSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a;
      label81:
      if ((localLocalMediaInfo == null) || ((localLocalMediaInfo.latitude == 0) && (localLocalMediaInfo.longitude == 0))) {
        break label158;
      }
      a(localLocalMediaInfo.latitude, localLocalMediaInfo.longitude);
    }
    label132:
    label158:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        super.f();
      }
      return;
      k = 0;
      break;
      label127:
      m = 0;
      break label48;
      if (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        break label81;
      }
      localLocalMediaInfo = ((EditLocalVideoSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a;
      break label81;
    }
  }
  
  public void g()
  {
    Object localObject1 = ((usp)urr.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int k = 0;
      while (k < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[k], jdField_a_of_type_ArrayOfJavaLangString[k], jdField_b_of_type_ArrayOfInt[k], this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        k += 1;
      }
    }
    Object localObject2 = a(-1, "", -1, this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      xej localxej = a((FilterItem)localObject2, this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      if (localxej != null)
      {
        wsv.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localxej);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvj
 * JD-Core Version:    0.7.0.1
 */