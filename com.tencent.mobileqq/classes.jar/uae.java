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

public class uae
  extends uab
{
  public final int a;
  public ArrayList<WeakReference<uah>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public uaj a;
  
  public uae(uaj paramuaj)
  {
    super(paramuaj);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Uaj = paramuaj;
    paramuaj = this.jdField_a_of_type_Uaj.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Uaj.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramuaj != null)
    {
      paramuaj = paramuaj.iterator();
      while (paramuaj.hasNext())
      {
        String str = (String)paramuaj.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    uag localuag = new uag();
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
    localuag.jdField_a_of_type_Boolean = true;
    localuag.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    veg.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localuag.jdField_a_of_type_JavaUtilArrayList.toString());
    ste.a().dispatch(localuag);
    this.jdField_a_of_type_Uaj.a().finish();
  }
  
  public void a(uah paramuah)
  {
    super.a(paramuah);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramuah));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(uah paramuah, int paramInt1, int paramInt2, uav paramuav)
  {
    super.a(paramuah, paramInt1, paramInt2, paramuav);
    paramuav = paramuav.a;
    if (TextUtils.isEmpty(paramuav)) {
      return;
    }
    ImageView localImageView = (ImageView)paramuah.jdField_a_of_type_AndroidViewView.findViewById(2131367874);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramuav)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramuav)).booleanValue()))
    {
      localImageView.setImageResource(2130843924);
      paramuav = (TextView)paramuah.jdField_a_of_type_AndroidViewView.findViewById(2131377192);
      paramuav.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramuah = ajyc.a(2131713772);
      label118:
      paramuav.setText(paramuah);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramuav.setEnabled(bool);
      return;
      localImageView.setImageResource(2130844858);
      break;
      paramuah = ajyc.a(2131713775) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(uah paramuah, View paramView)
  {
    super.a(paramuah, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367874: 
      paramuah = paramuah.jdField_a_of_type_Uav.a;
      vxs.a(paramuah);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramuah))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramuah);
        ((ImageView)paramView).setImageResource(2130844858);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramuah = (uah)((WeakReference)paramView.next()).get();
        } while (paramuah == null);
        localTextView = (TextView)paramuah.jdField_a_of_type_AndroidViewView.findViewById(2131377192);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramuah = ajyc.a(2131713774);
        label147:
        localTextView.setText(paramuah);
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
          paramuah = bbcv.a(this.jdField_a_of_type_Uaj.a(), 230);
          paramuah.setMessage(String.format(ajyc.a(2131713777), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), ssi.a }));
          paramuah.setPositiveButton(ajyc.a(2131713771), new uaf(this));
          paramuah.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramuah, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130843924);
        break;
        paramuah = ajyc.a(2131713770) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(uah paramuah, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramuah.jdField_a_of_type_AndroidViewView.findViewById(2131377192);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramuah = ajyc.a(2131713773);
      localTextView.setText(paramuah);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramuah = ajyc.a(2131713776) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uae
 * JD-Core Version:    0.7.0.1
 */