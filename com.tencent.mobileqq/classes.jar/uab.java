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

public class uab
  extends tzy
{
  public final int a;
  public ArrayList<WeakReference<uae>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public uag a;
  
  public uab(uag paramuag)
  {
    super(paramuag);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Uag = paramuag;
    paramuag = this.jdField_a_of_type_Uag.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Uag.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramuag != null)
    {
      paramuag = paramuag.iterator();
      while (paramuag.hasNext())
      {
        String str = (String)paramuag.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    uad localuad = new uad();
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
    localuad.jdField_a_of_type_Boolean = true;
    localuad.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    ved.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localuad.jdField_a_of_type_JavaUtilArrayList.toString());
    stb.a().dispatch(localuad);
    this.jdField_a_of_type_Uag.a().finish();
  }
  
  public void a(uae paramuae)
  {
    super.a(paramuae);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramuae));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(uae paramuae, int paramInt1, int paramInt2, uas paramuas)
  {
    super.a(paramuae, paramInt1, paramInt2, paramuas);
    paramuas = paramuas.a;
    if (TextUtils.isEmpty(paramuas)) {
      return;
    }
    ImageView localImageView = (ImageView)paramuae.jdField_a_of_type_AndroidViewView.findViewById(2131367874);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramuas)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramuas)).booleanValue()))
    {
      localImageView.setImageResource(2130843925);
      paramuas = (TextView)paramuae.jdField_a_of_type_AndroidViewView.findViewById(2131377194);
      paramuas.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramuae = ajya.a(2131713783);
      label118:
      paramuas.setText(paramuae);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramuas.setEnabled(bool);
      return;
      localImageView.setImageResource(2130844859);
      break;
      paramuae = ajya.a(2131713786) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(uae paramuae, View paramView)
  {
    super.a(paramuae, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367874: 
      paramuae = paramuae.jdField_a_of_type_Uas.a;
      vxp.a(paramuae);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramuae))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramuae);
        ((ImageView)paramView).setImageResource(2130844859);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramuae = (uae)((WeakReference)paramView.next()).get();
        } while (paramuae == null);
        localTextView = (TextView)paramuae.jdField_a_of_type_AndroidViewView.findViewById(2131377194);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramuae = ajya.a(2131713785);
        label147:
        localTextView.setText(paramuae);
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
          paramuae = bbdj.a(this.jdField_a_of_type_Uag.a(), 230);
          paramuae.setMessage(String.format(ajya.a(2131713788), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), ssf.a }));
          paramuae.setPositiveButton(ajya.a(2131713782), new uac(this));
          paramuae.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramuae, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130843925);
        break;
        paramuae = ajya.a(2131713781) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(uae paramuae, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramuae.jdField_a_of_type_AndroidViewView.findViewById(2131377194);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramuae = ajya.a(2131713784);
      localTextView.setText(paramuae);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramuae = ajya.a(2131713787) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uab
 * JD-Core Version:    0.7.0.1
 */