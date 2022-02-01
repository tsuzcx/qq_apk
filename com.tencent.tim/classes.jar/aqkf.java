import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

public class aqkf
  extends ReportDialog
{
  TextView abz;
  private BaseAdapter adapter = new aqkg(this);
  LinearLayout bodyLayout;
  LayoutInflater inflater;
  String[] items;
  TextView lBtn;
  ListView list;
  DialogInterface.OnClickListener onArrayItemClick;
  TextView previewImage;
  TextView rBtn;
  TextView text;
  TextView title;
  
  public aqkf(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void eec()
  {
    TextView localTextView = null;
    if (this.rBtn.getVisibility() == 0) {
      localTextView = this.rBtn;
    }
    for (;;)
    {
      if (localTextView != null) {}
      return;
      if (this.abz.getVisibility() == 0) {
        localTextView = this.abz;
      } else if (this.lBtn.getVisibility() == 0) {
        localTextView = this.lBtn;
      }
    }
  }
  
  private void setSeperatorState()
  {
    eec();
  }
  
  public aqkf a(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(paramString);
      this.title.setVisibility(0);
      if (this.items == null) {}
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public aqkf a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new aqkh(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqkf b(String paramString)
  {
    if (paramString != null)
    {
      this.text.setText(paramString);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public aqkf b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.abz.setVisibility(8);
      return this;
    }
    this.abz.setText(paramString);
    this.abz.setVisibility(0);
    this.abz.setOnClickListener(new aqki(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqkf c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aqkj(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    return paramInt;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131365867));
    this.text = ((TextView)findViewById(2131365863));
    this.previewImage = ((TextView)findViewById(2131373567));
    this.lBtn = ((TextView)findViewById(2131365852));
    this.abz = ((TextView)findViewById(2131365855));
    this.rBtn = ((TextView)findViewById(2131365858));
    this.lBtn.setVisibility(8);
    this.abz.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(2131363579));
    this.list = ((ListView)findViewById(2131370527));
  }
  
  public void setTitle(int paramInt)
  {
    this.title.setText(paramInt);
    this.title.setVisibility(0);
  }
  
  class a
    implements View.OnClickListener
  {
    int i;
    
    public a(int paramInt)
    {
      this.i = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (aqkf.this.onArrayItemClick != null)
      {
        aqkf.this.onArrayItemClick.onClick(aqkf.this, aqkf.this.customWhichToCallBack(this.i));
        aqkf.this.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  class b
  {
    TextView text;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkf
 * JD-Core Version:    0.7.0.1
 */