import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class sms
  extends BaseAdapter
{
  private short H;
  public String aEI;
  public String aEJ;
  public String aEK;
  private String aEL;
  Activity context;
  public String filePath;
  LayoutInflater inflater;
  private boolean mIsHttps;
  public long nSessionId;
  List<agxi.a> pw;
  public String str_download_dns;
  public long troopUin;
  
  public sms(List<agxi.a> paramList, Activity paramActivity)
  {
    this.inflater = LayoutInflater.from(paramActivity);
    this.pw = paramList;
    this.context = paramActivity;
  }
  
  public void a(boolean paramBoolean, String paramString, short paramShort)
  {
    this.mIsHttps = paramBoolean;
    this.aEL = paramString;
    this.H = paramShort;
  }
  
  public void ff(List<agxi.a> paramList)
  {
    this.pw = paramList;
  }
  
  public int getCount()
  {
    return this.pw.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    sms.a locala;
    if (paramView == null)
    {
      paramView = this.inflater.inflate(2131561070, null);
      locala = new sms.a();
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367054));
      locala.nameTv = ((TextView)paramView.findViewById(2131367059));
      locala.AB = ((TextView)paramView.findViewById(2131367062));
      locala.qk = paramView.findViewById(2131377281);
      paramView.setTag(locala);
      paramView.setOnClickListener(new smt(this));
    }
    for (;;)
    {
      locala = (sms.a)paramView.getTag();
      agxi.a locala1 = (agxi.a)this.pw.get(paramInt);
      if (locala1.isDir)
      {
        locala.AB.setText(acfp.m(2131717006));
        locala.nameTv.setText(ahav.kY(locala1.name));
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130845137);
        locala.qk.setVisibility(0);
      }
      for (;;)
      {
        locala.jdField_a_of_type_Agxi$a = locala1;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        locala.AB.setText(ahbj.g(locala1.size));
        locala.nameTv.setText(ahav.kY(locala1.name));
        ahav.b(locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, locala1.name);
        locala.qk.setVisibility(8);
        if (ahav.getFileType(locala1.name) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.a().c(locala1.sessionId);
          localFileManagerEntity.isZipInnerFile = true;
          ahav.b(locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.a().c(localFileManagerEntity);
        }
      }
    }
  }
  
  public static class a
  {
    public TextView AB;
    public agxi.a a;
    public AsyncImageView a;
    public TextView nameTv;
    public View qk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */