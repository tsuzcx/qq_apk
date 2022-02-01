package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface OnActionCallback
{
  public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccessInMainThread(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.OnActionCallback
 * JD-Core Version:    0.7.0.1
 */