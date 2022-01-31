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

public class tni
  extends tnf
{
  public final int a;
  public ArrayList<WeakReference<tnl>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public tnn a;
  
  public tni(tnn paramtnn)
  {
    super(paramtnn);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Tnn = paramtnn;
    paramtnn = this.jdField_a_of_type_Tnn.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Tnn.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramtnn != null)
    {
      paramtnn = paramtnn.iterator();
      while (paramtnn.hasNext())
      {
        String str = (String)paramtnn.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    tnk localtnk = new tnk();
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
    localtnk.jdField_a_of_type_Boolean = true;
    localtnk.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    urk.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localtnk.jdField_a_of_type_JavaUtilArrayList.toString());
    sgi.a().dispatch(localtnk);
    this.jdField_a_of_type_Tnn.a().finish();
  }
  
  public void a(tnl paramtnl)
  {
    super.a(paramtnl);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramtnl));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(tnl paramtnl, int paramInt1, int paramInt2, tnz paramtnz)
  {
    super.a(paramtnl, paramInt1, paramInt2, paramtnz);
    paramtnz = paramtnz.a;
    if (TextUtils.isEmpty(paramtnz)) {
      return;
    }
    ImageView localImageView = (ImageView)paramtnl.jdField_a_of_type_AndroidViewView.findViewById(2131302254);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramtnz)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramtnz)).booleanValue()))
    {
      localImageView.setImageResource(2130843846);
      paramtnz = (TextView)paramtnl.jdField_a_of_type_AndroidViewView.findViewById(2131311381);
      paramtnz.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramtnl = ajjy.a(2131647985);
      label118:
      paramtnz.setText(paramtnl);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramtnz.setEnabled(bool);
      return;
      localImageView.setImageResource(2130844778);
      break;
      paramtnl = ajjy.a(2131647988) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(tnl paramtnl, View paramView)
  {
    super.a(paramtnl, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302254: 
      paramtnl = paramtnl.jdField_a_of_type_Tnz.a;
      vkw.a(paramtnl);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramtnl))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramtnl);
        ((ImageView)paramView).setImageResource(2130844778);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramtnl = (tnl)((WeakReference)paramView.next()).get();
        } while (paramtnl == null);
        localTextView = (TextView)paramtnl.jdField_a_of_type_AndroidViewView.findViewById(2131311381);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramtnl = ajjy.a(2131647987);
        label147:
        localTextView.setText(paramtnl);
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
          paramtnl = babr.a(this.jdField_a_of_type_Tnn.a(), 230);
          paramtnl.setMessage(String.format(ajjy.a(2131647990), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), sfm.a }));
          paramtnl.setPositiveButton(ajjy.a(2131647984), new tnj(this));
          paramtnl.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramtnl, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130843846);
        break;
        paramtnl = ajjy.a(2131647983) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(tnl paramtnl, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramtnl.jdField_a_of_type_AndroidViewView.findViewById(2131311381);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramtnl = ajjy.a(2131647986);
      localTextView.setText(paramtnl);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramtnl = ajjy.a(2131647989) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tni
 * JD-Core Version:    0.7.0.1
 */