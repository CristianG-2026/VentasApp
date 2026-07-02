package pe.idat.ventasapp.Vendedor

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import pe.idat.ventasapp.R
import pe.idat.ventasapp.Vendedor.Botton_Nav_Fragments_Vendedor.FragmentMisProductosV
import pe.idat.ventasapp.Vendedor.Botton_Nav_Fragments_Vendedor.FragmentOrdenesV
import pe.idat.ventasapp.Vendedor.Nav_Fragments_Vendedor.FragmentIncioV
import pe.idat.ventasapp.Vendedor.Nav_Fragments_Vendedor.FragmentMiTiendaV
import pe.idat.ventasapp.Vendedor.Nav_Fragments_Vendedor.FragmentReseniasV
import pe.idat.ventasapp.databinding.ActivityMainVendedorBinding
import pe.idat.ventasapp.databinding.FragmentOrdenesVBinding

class MainActivityVendedor : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainVendedorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainVendedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        binding.navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(FragmentIncioV())
        binding.navigationView.setCheckedItem(R.id.op_inicio_v)

        }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment, fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.op_inicio_v -> {
                replaceFragment(FragmentIncioV())
            }

            R.id.op_mi_tienda_v -> {
                replaceFragment(FragmentMiTiendaV())
            }

            R.id.op_resenia_v -> {
                replaceFragment(FragmentReseniasV())
            }

            R.id.op_cerrar_sesion_v -> {
                Toast.makeText(applicationContext, "Saliste de la aplicación", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.op_mis_productos_v -> {
                replaceFragment(FragmentMisProductosV())
            }

            R.id.op_mis_ordenes_v -> {
                replaceFragment(FragmentOrdenesV())
            }
        }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
                return true

        }
    }
