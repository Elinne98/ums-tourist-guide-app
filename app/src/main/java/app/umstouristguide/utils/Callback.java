package app.umstouristguide.utils;

public interface Callback<T> {

    void onSuccess(T result);

    void onError(String result);

}
