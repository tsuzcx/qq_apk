import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class vot
  extends voq
{
  public final int a;
  public ArrayList<WeakReference<vow>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public voy a;
  
  public vot(voy paramvoy)
  {
    super(paramvoy);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Voy = paramvoy;
    paramvoy = this.jdField_a_of_type_Voy.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Voy.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramvoy != null)
    {
      paramvoy = paramvoy.iterator();
      while (paramvoy.hasNext())
      {
        String str = (String)paramvoy.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    vov localvov = new vov();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(str);
      }
    }
    localvov.jdField_a_of_type_Boolean = true;
    localvov.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    wsv.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localvov.jdField_a_of_type_JavaUtilArrayList.toString());
    uht.a().dispatch(localvov);
    this.jdField_a_of_type_Voy.a().finish();
  }
  
  public void a(vow paramvow)
  {
    super.a(paramvow);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramvow));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(vow paramvow, int paramInt1, int paramInt2, vpk paramvpk)
  {
    super.a(paramvow, paramInt1, paramInt2, paramvpk);
    paramvpk = paramvpk.a;
    if (TextUtils.isEmpty(paramvpk)) {
      return;
    }
    ImageView localImageView = (ImageView)paramvow.jdField_a_of_type_AndroidViewView.findViewById(2131368009);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvpk)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvpk)).booleanValue()))
    {
      localImageView.setImageResource(2130844268);
      paramvpk = (TextView)paramvow.jdField_a_of_type_AndroidViewView.findViewById(2131377715);
      paramvpk.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramvow = alpo.a(2131714155);
      label118:
      paramvpk.setText(paramvow);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramvpk.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845223);
      break;
      paramvow = alpo.a(2131714158) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(vow paramvow, View paramView)
  {
    super.a(paramvow, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368009: 
      paramvow = paramvow.jdField_a_of_type_Vpk.a;
      xmh.a(paramvow);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvow))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvow);
        ((ImageView)paramView).setImageResource(2130845223);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramvow = (vow)((WeakReference)paramView.next()).get();
        } while (paramvow == null);
        localTextView = (TextView)paramvow.jdField_a_of_type_AndroidViewView.findViewById(2131377715);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramvow = alpo.a(2131714157);
        label147:
        localTextView.setText(paramvow);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label323;
        }
      }
      label285:
      label323:
      for (boolean bool = true;; bool = false)
      {
        localTextView.setEnabled(bool);
        break label87;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= this.jdField_a_of_type_Int)
        {
          paramvow = bdcd.a(this.jdField_a_of_type_Voy.a(), 230);
          paramvow.setMessage(String.format(alpo.a(2131714160), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), ugx.a }));
          paramvow.setPositiveButton(alpo.a(2131714154), new vou(this));
          paramvow.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramvow, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844268);
        break;
        paramvow = alpo.a(2131714153) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(vow paramvow, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramvow.jdField_a_of_type_AndroidViewView.findViewById(2131377715);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramvow = alpo.a(2131714156);
      localTextView.setText(paramvow);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramvow = alpo.a(2131714159) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vot
 * JD-Core Version:    0.7.0.1
 */