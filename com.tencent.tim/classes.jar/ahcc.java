import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahcc
{
  public static int M(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 106;
    }
    return DpUtil.dip2px(paramQQAppInterface.getApp(), 53.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ahcc.a parama)
  {
    if ((paramTeamWorkFileImportInfo == null) || (paramActivity == null)) {}
    do
    {
      return;
      paramActivity = paramActivity.getResources();
    } while (paramActivity == null);
    Object localObject = ax(paramTeamWorkFileImportInfo.fileName);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramTeamWorkFileImportInfo.peerType != 1)
      {
        paramTeamWorkFileImportInfo = ((List)localObject).iterator();
        while (paramTeamWorkFileImportInfo.hasNext())
        {
          localObject = (aett.a)paramTeamWorkFileImportInfo.next();
          if (((aett.a)localObject).getClickType() != 2) {
            localArrayList.add(localObject);
          }
        }
      }
      localArrayList.addAll((Collection)localObject);
    }
    a(paramQQAppInterface, paramActivity, paramView, localArrayList, parama);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Resources paramResources, View paramView, List<aett.a> paramList, ahcc.a parama)
  {
    if ((paramView == null) || (parama == null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramResources = (ViewGroup)paramView.findViewById(2131367233);
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131363641);
      if ((paramResources != null) && (localViewGroup != null))
      {
        paramView.setVisibility(8);
        paramResources.setVisibility(8);
        localViewGroup.setVisibility(8);
        LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          aett.a locala = (aett.a)paramList.next();
          switch (locala.getType())
          {
          default: 
            QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
            break;
          case 1: 
            a(paramQQAppInterface, paramView, parama, paramResources, localLayoutInflater, locala);
            break;
          case 2: 
            a(paramQQAppInterface, paramView, parama, paramResources, localViewGroup, localLayoutInflater, locala);
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, ahcc.a parama, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, aett.a parama1)
  {
    paramView.setVisibility(0);
    paramViewGroup.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131561053, paramViewGroup, false);
    paramLayoutInflater = (GradientDrawable)paramViewGroup.getBackground();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setAlpha(Math.round(parama1.getAlpha() * 255.0F));
      if (TextUtils.isEmpty(parama1.getColor())) {}
    }
    try
    {
      paramLayoutInflater.setColor(parseColor(parama1.getColor()));
      if (TextUtils.isEmpty(parama1.getTextColor())) {}
    }
    catch (NumberFormatException paramLayoutInflater)
    {
      try
      {
        ((TextView)paramView.findViewById(2131380579)).setTextColor(parseColor(parama1.getTextColor()));
        if (!TextUtils.isEmpty(parama1.getText())) {
          ((TextView)paramView.findViewById(2131380579)).setText(parama1.getText());
        }
        if (!TextUtils.isEmpty(parama1.getIconUrl()))
        {
          paramLayoutInflater = (URLImageView)paramView.findViewById(2131369680);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(parama1.getIconUrl(), localURLDrawableOptions));
        }
        paramView.setOnClickListener(new ahce(paramQQAppInterface, parama1.tY(), parama, parama1));
        if (parama1.getClickType() == 2) {
          parama.w((ImageView)paramView.findViewById(2131381235));
        }
        anot.a(paramQQAppInterface, "dc00898", "", "", parama1.tZ(), parama1.tZ(), 0, 0, "", "", "", "");
        paramViewGroup.addView(paramView);
        return;
        paramLayoutInflater = paramLayoutInflater;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramLayoutInflater);
      }
      catch (NumberFormatException paramLayoutInflater)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramLayoutInflater);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, ahcc.a parama, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, LayoutInflater paramLayoutInflater, aett.a parama1)
  {
    paramView.setVisibility(0);
    paramViewGroup2.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131561053, paramViewGroup1, false);
    paramViewGroup1 = (LayerDrawable)paramViewGroup2.getBackground();
    if (paramViewGroup1 != null)
    {
      paramViewGroup1 = (GradientDrawable)paramViewGroup1.findDrawableByLayerId(2131363236);
      paramViewGroup1.setAlpha(Math.round(parama1.getAlpha() * 255.0F));
      if (TextUtils.isEmpty(parama1.getColor())) {}
    }
    try
    {
      paramViewGroup1.setColor(parseColor(parama1.getColor()));
      if (TextUtils.isEmpty(parama1.getTextColor())) {}
    }
    catch (NumberFormatException paramViewGroup1)
    {
      try
      {
        ((TextView)paramView.findViewById(2131380579)).setTextColor(parseColor(parama1.getTextColor()));
        if (!TextUtils.isEmpty(parama1.getText())) {
          ((TextView)paramView.findViewById(2131380579)).setText(parama1.getText());
        }
        if (!TextUtils.isEmpty(parama1.getIconUrl()))
        {
          paramViewGroup1 = (URLImageView)paramView.findViewById(2131369680);
          paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup1.setImageDrawable(URLDrawable.getDrawable(parama1.getIconUrl(), paramLayoutInflater));
        }
        paramView.setOnClickListener(new ahcd(paramQQAppInterface, parama1.tY(), parama, parama1));
        if (parama1.getClickType() == 2) {
          parama.w((ImageView)paramView.findViewById(2131381235));
        }
        anot.a(paramQQAppInterface, "dc00898", "", "", parama1.tZ(), parama1.tZ(), 0, 0, "", "", "", "");
        paramViewGroup2.addView(paramView);
        return;
        paramViewGroup1 = paramViewGroup1;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramViewGroup1);
      }
      catch (NumberFormatException paramViewGroup1)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramViewGroup1);
        }
      }
    }
  }
  
  private static List<aett.a> ax(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ahbj.getExtension(paramString).toLowerCase().replace(".", "");
    return (List)aetu.a().ai().get(paramString);
  }
  
  public static boolean b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && (ev(paramTeamWorkFileImportInfo.fileName));
  }
  
  public static boolean ev(String paramString)
  {
    paramString = ax(paramString);
    return (paramString != null) && (paramString.size() > 0) && (((aett.a)paramString.get(0)).getType() != 0);
  }
  
  public static List<aett.a> fd()
  {
    return (List)aetu.a().ai().get("wording");
  }
  
  private static int parseColor(String paramString)
  {
    return Integer.decode(paramString).intValue() | 0xFF000000;
  }
  
  public static abstract interface a
  {
    public abstract void run(int paramInt);
    
    public abstract void w(ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcc
 * JD-Core Version:    0.7.0.1
 */