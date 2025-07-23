package com.google.mediapipe.examples.objectdetection;

/**
 * This ViewModel is used to store object detector helper settings
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_delegate", "", "_maxResults", "_model", "_threshold", "", "currentDelegate", "getCurrentDelegate", "()I", "currentMaxResults", "getCurrentMaxResults", "currentModel", "getCurrentModel", "currentThreshold", "getCurrentThreshold", "()F", "setDelegate", "", "delegate", "setMaxResults", "maxResults", "setModel", "model", "setThreshold", "threshold", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private int _delegate = 0;
    private float _threshold = 0.5F;
    private int _maxResults = 3;
    private int _model = 0;
    
    public MainViewModel() {
        super();
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final float getCurrentThreshold() {
        return 0.0F;
    }
    
    public final int getCurrentMaxResults() {
        return 0;
    }
    
    public final int getCurrentModel() {
        return 0;
    }
    
    public final void setDelegate(int delegate) {
    }
    
    public final void setThreshold(float threshold) {
    }
    
    public final void setMaxResults(int maxResults) {
    }
    
    public final void setModel(int model) {
    }
}