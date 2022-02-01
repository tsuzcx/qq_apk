import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class wrt
  extends wrq
{
  public final int a;
  public ArrayList<WeakReference<wrw>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public wry a;
  
  public wrt(wry paramwry)
  {
    super(paramwry);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Wry = paramwry;
    paramwry = this.jdField_a_of_type_Wry.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Wry.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramwry != null)
    {
      paramwry = paramwry.iterator();
      while (paramwry.hasNext())
      {
        String str = (String)paramwry.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    wrv localwrv = new wrv();
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
    localwrv.jdField_a_of_type_Boolean = true;
    localwrv.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    xvv.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localwrv.jdField_a_of_type_JavaUtilArrayList.toString());
    vli.a().dispatch(localwrv);
    this.jdField_a_of_type_Wry.a().finish();
  }
  
  public void a(wrw paramwrw)
  {
    super.a(paramwrw);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramwrw));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(wrw paramwrw, int paramInt1, int paramInt2, wsk paramwsk)
  {
    super.a(paramwrw, paramInt1, paramInt2, paramwsk);
    paramwsk = paramwsk.a;
    if (TextUtils.isEmpty(paramwsk)) {
      return;
    }
    ImageView localImageView = (ImageView)paramwrw.jdField_a_of_type_AndroidViewView.findViewById(2131368442);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramwsk)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramwsk)).booleanValue()))
    {
      localImageView.setImageResource(2130844624);
      paramwsk = (TextView)paramwrw.jdField_a_of_type_AndroidViewView.findViewById(2131378532);
      paramwsk.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramwrw = amtj.a(2131712880);
      label118:
      paramwsk.setText(paramwrw);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramwsk.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845585);
      break;
      paramwrw = amtj.a(2131712883) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(wrw paramwrw, View paramView)
  {
    super.a(paramwrw, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368442: 
      paramwrw = paramwrw.jdField_a_of_type_Wsk.a;
      yos.a(paramwrw);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramwrw))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramwrw);
        ((ImageView)paramView).setImageResource(2130845585);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramwrw = (wrw)((WeakReference)paramView.next()).get();
        } while (paramwrw == null);
        localTextView = (TextView)paramwrw.jdField_a_of_type_AndroidViewView.findViewById(2131378532);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramwrw = amtj.a(2131712882);
        label147:
        localTextView.setText(paramwrw);
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
          paramwrw = bfur.a(this.jdField_a_of_type_Wry.a(), 230);
          paramwrw.setMessage(String.format(amtj.a(2131712885), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), vkm.a }));
          paramwrw.setPositiveButton(amtj.a(2131712879), new wru(this));
          paramwrw.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramwrw, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844624);
        break;
        paramwrw = amtj.a(2131712878) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(wrw paramwrw, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramwrw.jdField_a_of_type_AndroidViewView.findViewById(2131378532);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramwrw = amtj.a(2131712881);
      localTextView.setText(paramwrw);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramwrw = amtj.a(2131712884) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrt
 * JD-Core Version:    0.7.0.1
 */