package br.com.ufv.projeto_loja.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.ufv.projeto_loja.Entidades.Cliente;
import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Entidades.Funcionario;
import br.com.ufv.projeto_loja.Entidades.Pessoa;
import br.com.ufv.projeto_loja.Entidades.Produto;
import br.com.ufv.projeto_loja.Entidades.VendaProduto;
import br.com.ufv.projeto_loja.Entidades.Vendas;




public class HibernateUtility {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		
		/*MAPEAMENTO DAS CLASS QUE USARAM O HIBERNATE*/
		configuration.addAnnotatedClass(Produto.class);
		configuration.addAnnotatedClass(Endereco.class);
		configuration.addAnnotatedClass(Pessoa.class);
		configuration.addAnnotatedClass(Cliente.class);
		configuration.addAnnotatedClass(Funcionario.class);
		configuration.addAnnotatedClass(Vendas.class);
		configuration.addAnnotatedClass(VendaProduto.class);
	
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}