package id.ac.uvers.donoryuk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class LoginTabFragment {
    public class RegisterTabFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater, ViewGroup container, Bundle savedInstanceState){
            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_fragment, container, attachToRoot: false);

            return root
        }

    }

}
