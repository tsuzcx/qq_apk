import java.util.List;

public abstract interface ljh
{
  public static abstract interface a<BEAN>
  {
    public abstract void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString);
  }
  
  public static abstract interface b<BEAN>
  {
    public abstract boolean Cz();
    
    public abstract void a(ljh.e<BEAN> parame);
    
    public abstract void a(boolean paramBoolean, ljh.a<BEAN> parama);
  }
  
  public static abstract interface c
    extends ljg
  {}
  
  public static abstract interface d<BEAN>
  {
    public abstract void setCenterEmpty();
    
    public abstract void setCenterError(int paramInt, String paramString);
    
    public abstract void setCenterHide();
    
    public abstract void setCenterLoading();
    
    public abstract void setFooterError(int paramInt, String paramString);
    
    public abstract void setFooterHasMore();
    
    public abstract void setFooterHide();
    
    public abstract void setFooterLoading();
    
    public abstract void setFooterNoMore();
    
    public abstract void setHeaderError(int paramInt, String paramString);
    
    public abstract void setHeaderLoading();
    
    public abstract void setHeaderSuccess();
    
    public abstract void setListData(List<BEAN> paramList, boolean paramBoolean);
    
    public abstract void setTotal(int paramInt);
  }
  
  public static abstract interface e<BEAN>
  {
    public abstract void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljh
 * JD-Core Version:    0.7.0.1
 */