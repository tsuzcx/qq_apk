package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import gvm;

public class TroopBarPostLayoutRelativeGroup
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903452;
  protected static final String a = "本部落的群(%d)";
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903452, null);
      paramLayoutInflater = (gvm)a(paramView);
      paramView.setTag(paramLayoutInflater);
    }
    for (;;)
    {
      TextView localTextView = paramLayoutInflater.a;
      Object localObject = paramActivity.getResources();
      Drawable localDrawable = ((Resources)localObject).getDrawable(2130838439);
      localObject = ((Resources)localObject).getDrawable(2130838440);
      paramTroopBarAbsDataEntity = (TroopBarPageEntity)paramTroopBarAbsDataEntity;
      localTextView.setText(String.format("本部落的群(%d)", new Object[] { Integer.valueOf(paramTroopBarAbsDataEntity.group_count) }));
      paramLayoutInflater.a.setTag(2131230860, paramTroopBarAbsDataEntity);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, (Drawable)localObject, null);
      localTextView.setTextAppearance(paramActivity, 2131624121);
      localTextView.setOnClickListener(this);
      localTextView.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838512));
      return paramView;
      paramLayoutInflater = (gvm)paramView.getTag();
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new gvm(this, paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Context localContext;
    do
    {
      return;
      localContext = paramView.getContext();
      paramView = paramView.getTag(2131230860);
    } while ((localContext == null) || (!(paramView instanceof TroopBarPageEntity)));
    TroopBarPageEntity localTroopBarPageEntity = (TroopBarPageEntity)paramView;
    if (localTroopBarPageEntity.key_word == null) {}
    for (paramView = localTroopBarPageEntity.name;; paramView = localTroopBarPageEntity.key_word)
    {
      TroopBarUtils.a(localContext, "qqweb_index", new String[] { "&keyword=" + paramView, "&bid=" + localTroopBarPageEntity.id });
      TroopBarUtils.a("Clk_find", localTroopBarPageEntity.id, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayoutRelativeGroup
 * JD-Core Version:    0.7.0.1
 */