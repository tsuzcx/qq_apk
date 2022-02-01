package retrofit;

import retrofit.client.Response;

public abstract interface Callback<T>
{
  public abstract void failure(RetrofitError paramRetrofitError);
  
  public abstract void success(T paramT, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Callback
 * JD-Core Version:    0.7.0.1
 */