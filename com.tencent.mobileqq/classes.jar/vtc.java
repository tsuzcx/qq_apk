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

public class vtc
  extends vsz
{
  public final int a;
  public ArrayList<WeakReference<vtf>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public vth a;
  
  public vtc(vth paramvth)
  {
    super(paramvth);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Vth = paramvth;
    paramvth = this.jdField_a_of_type_Vth.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Vth.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramvth != null)
    {
      paramvth = paramvth.iterator();
      while (paramvth.hasNext())
      {
        String str = (String)paramvth.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    vte localvte = new vte();
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
    localvte.jdField_a_of_type_Boolean = true;
    localvte.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    wxe.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localvte.jdField_a_of_type_JavaUtilArrayList.toString());
    umc.a().dispatch(localvte);
    this.jdField_a_of_type_Vth.a().finish();
  }
  
  public void a(vtf paramvtf)
  {
    super.a(paramvtf);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramvtf));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(vtf paramvtf, int paramInt1, int paramInt2, vtt paramvtt)
  {
    super.a(paramvtf, paramInt1, paramInt2, paramvtt);
    paramvtt = paramvtt.a;
    if (TextUtils.isEmpty(paramvtt)) {
      return;
    }
    ImageView localImageView = (ImageView)paramvtf.jdField_a_of_type_AndroidViewView.findViewById(2131368020);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvtt)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvtt)).booleanValue()))
    {
      localImageView.setImageResource(2130844340);
      paramvtt = (TextView)paramvtf.jdField_a_of_type_AndroidViewView.findViewById(2131377769);
      paramvtt.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramvtf = alud.a(2131714167);
      label118:
      paramvtt.setText(paramvtf);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramvtt.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845295);
      break;
      paramvtf = alud.a(2131714170) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(vtf paramvtf, View paramView)
  {
    super.a(paramvtf, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368020: 
      paramvtf = paramvtf.jdField_a_of_type_Vtt.a;
      xqq.a(paramvtf);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvtf))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvtf);
        ((ImageView)paramView).setImageResource(2130845295);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramvtf = (vtf)((WeakReference)paramView.next()).get();
        } while (paramvtf == null);
        localTextView = (TextView)paramvtf.jdField_a_of_type_AndroidViewView.findViewById(2131377769);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramvtf = alud.a(2131714169);
        label147:
        localTextView.setText(paramvtf);
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
          paramvtf = bdgm.a(this.jdField_a_of_type_Vth.a(), 230);
          paramvtf.setMessage(String.format(alud.a(2131714172), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), ulg.a }));
          paramvtf.setPositiveButton(alud.a(2131714166), new vtd(this));
          paramvtf.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramvtf, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844340);
        break;
        paramvtf = alud.a(2131714165) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(vtf paramvtf, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramvtf.jdField_a_of_type_AndroidViewView.findViewById(2131377769);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramvtf = alud.a(2131714168);
      localTextView.setText(paramvtf);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramvtf = alud.a(2131714171) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtc
 * JD-Core Version:    0.7.0.1
 */