package com.app.hubert.guide.model;

import android.view.View.OnClickListener;
import com.app.hubert.guide.listener.OnHighlightDrewListener;

public class HighlightOptions
{
  public boolean fetchLocationEveryTime;
  public View.OnClickListener onClickListener;
  public OnHighlightDrewListener onHighlightDrewListener;
  public RelativeGuide relativeGuide;
  
  public static class Builder
  {
    private HighlightOptions options = new HighlightOptions();
    
    public HighlightOptions build()
    {
      return this.options;
    }
    
    public Builder isFetchLocationEveryTime(boolean paramBoolean)
    {
      this.options.fetchLocationEveryTime = paramBoolean;
      return this;
    }
    
    public Builder setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.options.onClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setOnHighlightDrewListener(OnHighlightDrewListener paramOnHighlightDrewListener)
    {
      this.options.onHighlightDrewListener = paramOnHighlightDrewListener;
      return this;
    }
    
    public Builder setRelativeGuide(RelativeGuide paramRelativeGuide)
    {
      this.options.relativeGuide = paramRelativeGuide;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.model.HighlightOptions
 * JD-Core Version:    0.7.0.1
 */