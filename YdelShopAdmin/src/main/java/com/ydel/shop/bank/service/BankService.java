package com.ydel.shop.bank.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ydel.shop.bank.bo.BankBO;
import com.ydel.shop.jaxbeans.bank.schemas.BankBean;
import com.ydel.shop.response.bank.schemas.BankResponseBean;
import com.ydel.shop.service.core.schemas.EntityBean;
import com.ydel.shop.service.core.schemas.ResponseData;
import com.ydel.shop.service.core.schemas.StatusBean;
import com.ydel.shop.utils.JPAUtil;
import com.ydel.shop.utils.ServiceHelper;

@PersistenceContext(name="JPAEntityManager",unitName="YdelShopEntities",type=PersistenceContextType.TRANSACTION)
@Path("/bank")
public class BankService {
	
	
	ServiceHelper helper = new ServiceHelper();
	//private static UrlLog logger = new urlLog();
	StatusBean statusBean = new StatusBean();
	ResponseData responseData = new ResponseData();
	ResponseData rootResponse = new ResponseData();
	BankResponseBean bankResponseBean = new BankResponseBean();
	BankBO bankBO = new BankBO();
	@Context
	HttpServletRequest httpRequest;
	
	/***************************************************/
	/**
	 * This method is used for create Brand. @ Service Name : createBrand @
	 * Category : Brand @ URI : brand/create @ Request Type : @POST @ Parameter
	 * Type : @FormParam @ Response Type : JSON, XML @ Description : The method
	 * will create the Brand. @ Returns : Response
	 */
	

	@POST
	@Path("/create")
	@Consumes(
	{ MediaType.MULTIPART_FORM_DATA })
	@Produces(
	{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createBank(@FormDataParam("bankCode")String bankCode,
				@FormDataParam("bankName")String bankName,@FormDataParam("bankAddress")String bankAddress)
	{
		BankBO bankBO = new BankBO();
		BankBean bankBean = new BankBean();
		BankResponseBean bankResponseBean = new BankResponseBean();
		ResponseData rootResponse = new ResponseData();
		EntityBean entityBean = new EntityBean();
		try {
			
			helper.beginTransaction1();
			
			
			bankBean.setBankCode(bankCode);
			bankBean.setBankName(bankName);
			bankBean.setBankAddress(bankAddress);
			
			BankBean bankBean2= bankBO.createBank(JPAUtil.getEntityManager1(), bankBean);
			helper.commitTransaction();
			
			if(bankBean2.getFaultBean().isSuccess())
			{
				//logger.infoMessage("BankService : createBank() : Bank Request Created Successfully.");
				statusBean.setStatusMessage("BankService: created successfully...");
				statusBean.setSuccess(true);
				entityBean.setBankBean(bankBean2);
				bankResponseBean.setEntityBean(entityBean);
				bankResponseBean.setStatusBean(statusBean);
				rootResponse.setBankResponseBeanFind(bankResponseBean);
				//bankResponseBean.setBankBeanFind(bankBean2);
			}
			else
			{
			//	logger.infoMessage("EmployeeService : createEmployee()  : Charge Request Creation Failed.");
				statusBean.setStatusMessage("BankService  Creation Failed.");
				statusBean.setSuccess(false);
				bankResponseBean.setEntityBean(entityBean);
				bankResponseBean.setStatusBean(statusBean);
				rootResponse.setBankResponseBeanFind(bankResponseBean);
				//return Response.status(Response.Status.BAD_REQUEST).entity(rootResponse).build();
			}
			return Response.status(Response.Status.BAD_REQUEST).entity(rootResponse).build();

		}
		catch (Exception exc)
		{
			try
			{
				helper.rollbackTransaction();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			//logger.errorMessage("EmployeeService : createEmployee() : Exception Occured is ==> " + exc);
			statusBean.setStatusMessage("BankService Creation Failed.");
			statusBean.setSuccess(false);
			bankResponseBean.setStatusBean(statusBean);
			rootResponse.setBankResponseBeanFind(bankResponseBean);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(rootResponse).build();
		}
		finally
		{
			JPAUtil.closeEntityManager1();
		}
		
		
	}
	
	// get all
	
		@GET
		@Path("/all")
		@Produces(
		{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response findAllBank()
		{
			BankBO bankBO = new BankBO();
			new BankBean();
			BankResponseBean bankResponseBean = new BankResponseBean();
			ResponseData rootResponse = new ResponseData();
			
			try
			{
				
				List<BankBean> bankBeanList = bankBO.findAllBank(JPAUtil.getEntityManager1());
				if (bankBeanList.size() > 0)
				{
					
					statusBean.setStatusMessage(" Bank Received Successfully : " + bankBeanList.size());
					
					statusBean.setSuccess(true);
					
					EntityBean entityBean = new EntityBean();
					entityBean.setBankBeanList(bankBeanList);
					bankResponseBean.setEntityBean(entityBean);
					bankResponseBean.setStatusBean(statusBean);
					
					rootResponse.setBankResponseBeanFind(bankResponseBean);
					return Response.status(Response.Status.OK).entity(rootResponse).build();
				}
				else
				{
					
					statusBean.setStatusMessage("No Bank Found.");
					statusBean.setSuccess(false);
					EntityBean entityBean = new EntityBean();
					entityBean.setBankBeanList(bankBeanList);
					bankResponseBean.setEntityBean(entityBean);
					bankResponseBean.setStatusBean(statusBean);
					rootResponse.setBankResponseBeanFind(bankResponseBean);
				}
				return Response.status(Response.Status.OK).entity(rootResponse).build();
			}
			catch (Exception exc)
			{
				
				statusBean.setStatusMessage("Something  Went Wrong! Try Again!!!!!!!");
				statusBean.setSuccess(false);
				EntityBean entityBean = new EntityBean();
				bankResponseBean.setEntityBean(entityBean);
				bankResponseBean.setStatusBean(statusBean);
				rootResponse.setBankResponseBeanFind(bankResponseBean);
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(rootResponse).build();
			}
			finally
			{
				JPAUtil.closeEntityManager1();
			}
		}
		
	
}
