package com.example.android_mvvm.sample;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android_mvvm.ViewModel;
import com.example.android_mvvm.sample.BR;
import com.example.android_mvvm.adapters.RecyclerViewAdapter;
import com.example.android_mvvm.adapters.ViewModelBinder;
import com.example.android_mvvm.adapters.ViewProvider;

import java.util.List;

import rx.Observable;

@SuppressWarnings("unused")
public class BindingAdapters {

    @BindingAdapter({"items", "view_provider"})
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, Observable<List<ViewModel>> items, ViewProvider viewProvider) {
        RecyclerViewAdapter adapter = null;
        if (items != null) {
            adapter = new RecyclerViewAdapter(items, viewProvider, new ViewModelBinder() {
                @Override
                public void bind(ViewDataBinding viewDataBinding, ViewModel viewModel) {
                    viewDataBinding.setVariable(BR.vm, viewModel);
                }
            });
        }
        recyclerView.setAdapter(adapter);
    }
}
