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

public class vgu
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String i = ajyc.a(2131703910);
  public static final String j = ajyc.a(2131703724);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private tcc<tdt> jdField_a_of_type_Tcc = new vgv(this);
  private vqg jdField_a_of_type_Vqg;
  private SparseArray<vpu> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "", jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, f, g, h, j };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
  }
  
  public vgu(@NonNull vhp paramvhp)
  {
    super(paramvhp);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private vpu a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int k = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    vpu localvpu = (vpu)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (k >= 0)
    {
      paramString = (vpu)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(k);
      return paramString;
    }
    Object localObject = (vlv)tdc.a(8);
    localObject = localvpu;
    switch (paramInt1)
    {
    default: 
      localObject = localvpu;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new vqe(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localvpu;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new vqe(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localvpu;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new vqe(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localvpu;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new vqe(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localvpu;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((tcv)tdc.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
              {
                veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new vqe(paramString, paramInt2, 2130845614, 2);
                continue;
                localObject = localvpu;
                if (this.jdField_a_of_type_Vpw != null)
                {
                  localObject = new vpw(this.jdField_a_of_type_Vpw.jdField_a_of_type_Int, paramString, paramInt2, this.jdField_a_of_type_Vpw.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Vpw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Vpw.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Vpw.f, this.jdField_a_of_type_Vpw.g, this.jdField_a_of_type_Vpw.h, this.jdField_a_of_type_Vpw.i, this.jdField_a_of_type_Vpw.jdField_c_of_type_Int, this.jdField_a_of_type_Vpw.jdField_d_of_type_Int, this.jdField_a_of_type_Vpw.jdField_e_of_type_Int);
                  continue;
                  if (!(paramEditSource instanceof EditRecordVideoSource))
                  {
                    localObject = localvpu;
                    if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                  }
                  else if (((this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!avxp.a))
                  {
                    veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else if ((this.jdField_a_of_type_Vhp.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Vhp.a.h()))
                  {
                    veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe revert black model ! disable revert");
                    localObject = null;
                  }
                  else
                  {
                    localObject = new vqe(paramString, paramInt2, 2130845613, 1);
                    continue;
                    if (!(paramEditSource instanceof EditRecordVideoSource))
                    {
                      localObject = localvpu;
                      if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                    }
                    else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                    {
                      localObject = localvpu;
                      if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                    }
                    else
                    {
                      localObject = localvpu;
                      if (!"X9000".equalsIgnoreCase(Build.MODEL))
                      {
                        bool = ((Boolean)((tcv)tdc.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
                        {
                          veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else if ((this.jdField_a_of_type_Vhp.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Vhp.a.i()))
                        {
                          veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe slow black model ! disable slow");
                          localObject = null;
                        }
                        else
                        {
                          localObject = new vqe(paramString, paramInt2, 2130845615, 3);
                          continue;
                          localObject = new vqb(0, paramString, paramInt2);
                          continue;
                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                          {
                            localObject = localvpu;
                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                          }
                          else
                          {
                            if ((this.jdField_a_of_type_Vpw != null) && (b())) {
                              break label926;
                            }
                            if (this.jdField_a_of_type_Vpw == null) {
                              veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                            }
                            localObject = localvpu;
                            if (!b())
                            {
                              veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                              localObject = localvpu;
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
    paramEditSource = (tdq)((tcd)tdc.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      veg.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Vqg = new vqg(0, paramString, paramInt2, ((tdt)localObject).jdField_a_of_type_Int);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Vqg;
      break;
      veg.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Vqg = new vqg(0, paramString, paramInt2, 0);
      paramEditSource.a();
    }
  }
  
  private vpu a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    case 8: 
    default: 
      return null;
    case 10: 
      paramEditSource = ((tea)tdc.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new vpy(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, tea.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    veg.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    tmq localtmq = new tmq(1, paramInt2, paramInt1);
    syr.a().a(localtmq, new vgw(this));
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_Vja.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((tdq)((tcd)tdc.a(20)).a(0)).a(this.jdField_a_of_type_Tcc);
  }
  
  public void a(int paramInt, tbx paramtbx)
  {
    veg.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), paramtbx, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_Vja.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new EditVideoFilterNeo.3(this, paramtbx));
      }
    }
    else
    {
      return;
    }
    veg.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  public void d()
  {
    ((tdq)((tcd)tdc.a(20)).a(0)).b(this.jdField_a_of_type_Tcc);
    super.d();
  }
  
  public void f()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_Vhp.a;
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
    Object localObject1 = ((tea)tdc.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int k = 0;
      while (k < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[k], jdField_a_of_type_ArrayOfJavaLangString[k], jdField_b_of_type_ArrayOfInt[k], this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        k += 1;
      }
    }
    Object localObject2 = a(-1, "", -1, this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      vpu localvpu = a((FilterItem)localObject2, this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      if (localvpu != null)
      {
        veg.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localvpu);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgu
 * JD-Core Version:    0.7.0.1
 */