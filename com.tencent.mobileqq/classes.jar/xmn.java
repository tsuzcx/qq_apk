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

public class xmn
  extends xmk
{
  public final int a;
  public ArrayList<WeakReference<xmq>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public xms a;
  
  public xmn(xms paramxms)
  {
    super(paramxms);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Xms = paramxms;
    paramxms = this.jdField_a_of_type_Xms.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Xms.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramxms != null)
    {
      paramxms = paramxms.iterator();
      while (paramxms.hasNext())
      {
        String str = (String)paramxms.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    xmp localxmp = new xmp();
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
    localxmp.jdField_a_of_type_Boolean = true;
    localxmp.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    yqp.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localxmp.jdField_a_of_type_JavaUtilArrayList.toString());
    wfo.a().dispatch(localxmp);
    this.jdField_a_of_type_Xms.a().finish();
  }
  
  public void a(xmq paramxmq)
  {
    super.a(paramxmq);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramxmq));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(xmq paramxmq, int paramInt1, int paramInt2, xne paramxne)
  {
    super.a(paramxmq, paramInt1, paramInt2, paramxne);
    paramxne = paramxne.a;
    if (TextUtils.isEmpty(paramxne)) {
      return;
    }
    ImageView localImageView = (ImageView)paramxmq.jdField_a_of_type_AndroidViewView.findViewById(2131368345);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxne)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxne)).booleanValue()))
    {
      localImageView.setImageResource(2130844734);
      paramxne = (TextView)paramxmq.jdField_a_of_type_AndroidViewView.findViewById(2131378608);
      paramxne.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramxmq = anni.a(2131712539);
      label118:
      paramxne.setText(paramxmq);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramxne.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845691);
      break;
      paramxmq = anni.a(2131712542) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(xmq paramxmq, View paramView)
  {
    super.a(paramxmq, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368345: 
      paramxmq = paramxmq.jdField_a_of_type_Xne.a;
      zkb.a(paramxmq);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxmq))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxmq);
        ((ImageView)paramView).setImageResource(2130845691);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramxmq = (xmq)((WeakReference)paramView.next()).get();
        } while (paramxmq == null);
        localTextView = (TextView)paramxmq.jdField_a_of_type_AndroidViewView.findViewById(2131378608);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramxmq = anni.a(2131712541);
        label147:
        localTextView.setText(paramxmq);
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
          paramxmq = bglp.a(this.jdField_a_of_type_Xms.a(), 230);
          paramxmq.setMessage(String.format(anni.a(2131712544), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), wes.a }));
          paramxmq.setPositiveButton(anni.a(2131712538), new xmo(this));
          paramxmq.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramxmq, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844734);
        break;
        paramxmq = anni.a(2131712537) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(xmq paramxmq, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramxmq.jdField_a_of_type_AndroidViewView.findViewById(2131378608);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramxmq = anni.a(2131712540);
      localTextView.setText(paramxmq);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramxmq = anni.a(2131712543) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmn
 * JD-Core Version:    0.7.0.1
 */