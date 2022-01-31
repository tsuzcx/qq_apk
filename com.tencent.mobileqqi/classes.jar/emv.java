import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class emv
  implements AdapterView.OnItemClickListener
{
  public emv(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 2;
    switch (this.a.jdField_a_of_type_Ena.getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
      if (!PhotoListActivity.f(this.a)) {
        PhotoListActivity.c(this.a, true);
      }
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramAdapterView = this.a.jdField_a_of_type_Ena.a(paramInt);
        PhotoListActivity.a(this.a, paramAdapterView.a);
        return;
      }
      ena localena = this.a.jdField_a_of_type_Ena;
      LocalPhotoInfo localLocalPhotoInfo = localena.a(paramInt);
      paramInt = localLocalPhotoInfo.e;
      if ((paramInt == 2) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() >= this.a.c))
      {
        QQToast.a(this.a, this.a.getString(2131558990, new Object[] { Integer.valueOf(this.a.c) }), 0).b(this.a.d);
        return;
      }
      label209:
      String str;
      if (paramInt == 1)
      {
        paramInt = i;
        localLocalPhotoInfo.e = paramInt;
        if (localLocalPhotoInfo.e != 1) {
          break label381;
        }
        paramInt = 1;
        str = localLocalPhotoInfo.a;
        if (paramInt == 0) {
          break label386;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
        paramView = (LinkedHashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
        paramAdapterView = paramView;
        if (paramView == null)
        {
          paramAdapterView = new LinkedHashMap();
          AlbumUtil.b.put(PhotoListActivity.a(this.a), paramAdapterView);
        }
        paramAdapterView.put(str, Integer.valueOf(this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q()));
        paramAdapterView = AlbumUtil.c;
        if (!paramAdapterView.containsKey(str)) {
          paramAdapterView.put(str, new Pair(PhotoListActivity.a(this.a), PhotoListActivity.b(this.a)));
        }
      }
      for (;;)
      {
        localena.notifyDataSetChanged();
        if (PhotoListActivity.a(this.a) == 1) {
          PhotoListActivity.b(this.a, localLocalPhotoInfo.a);
        }
        PhotoListActivity.a(this.a);
        return;
        paramInt = 1;
        break;
        label381:
        paramInt = 0;
        break label209;
        label386:
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(str);
        paramAdapterView = (HashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
        if (paramAdapterView != null) {
          paramAdapterView.remove(str);
        }
        paramAdapterView = AlbumUtil.c;
        if (paramAdapterView.containsKey(str)) {
          paramAdapterView.remove(str);
        }
      }
    }
    if (!Utils.e())
    {
      Toast.makeText(this.a, this.a.getResources().getString(2131562496), 0).show();
      return;
    }
    PhotoListActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emv
 * JD-Core Version:    0.7.0.1
 */